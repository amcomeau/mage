package mage.cards.d;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.condition.InvertCondition;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.BoostAllEffect;
import mage.abilities.effects.common.cost.SpellsCostReductionControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.TargetController;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.combat.CombatGroup;
import mage.game.events.GameEvent;
import mage.game.permanent.Permanent;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;
import mage.filter.FilterCard;
import mage.filter.common.FilterAttackingCreature;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.targetpointer.FixedTargets;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * @author amcomeau
 */
public final class DroneSevenOfNine extends CardImpl {

    private static final FilterCard filter = new FilterCard("Borg spells");

    static {
        filter.add(SubType.BORG.getPredicate());
    }

    public DroneSevenOfNine(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{B}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);

        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Borg spells you cast cost {1} less to cast.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new SpellsCostReductionControllerEffect(filter, 1)));

        // Whenever one or more creatures attack an opponent, those creatures get +1/+0 until end of turn.
        this.addAbility(new DroneSevenOfNineTriggeredAbility1());

        // All creatures attacking you get -1/-0.
        addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new ConditionalContinuousEffect(
                new BoostAllEffect(-1, 0, Duration.WhileOnBattlefield, new DroneSevenOfNineFilter(), false)
	   );
    }

    private DroneSevenOfNine(final DroneSevenOfNine card) {
        super(card);
    }

    @Override
    public DroneSevenOfNine copy() {
        return new DroneSevenOfNine(this);
    }
}

class DroneSevenOfNineTriggeredAbility1 extends TriggeredAbilityImpl {

    DroneSevenOfNineTriggeredAbility1() {
        super(Zone.BATTLEFIELD, new GainAbilityTargetEffect(new BoostTargetEffect(1, 1, Duration.EndOfTurn)), false);
    }

    private DroneSevenOfNineTriggeredAbility1(final DroneSevenOfNineTriggeredAbility1 ability) {
        super(ability);
    }

    @Override
    public DroneSevenOfNineTriggeredAbility1 copy() {
        return new DroneSevenOfNineTriggeredAbility1(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.DECLARED_ATTACKERS;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        Set<UUID> opponents = game.getOpponents(this.getControllerId());
        Predicate<UUID> predicate = uuid -> opponents.contains(game.getCombat().getDefendingPlayerId(uuid, game));
        if (game.getCombat().getAttackers().stream().noneMatch(predicate)) {
            return false;
        }
        List<Permanent> permanents = game
                .getCombat()
                .getAttackers()
                .stream()
                .filter(predicate)
                .map(game::getPermanent)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        this.getEffects().setTargetPointer(new FixedTargets(permanents, game));
        return true;
    }

    @Override
    public String getRule() {
        return "Whenever one or more creatures attack an opponent, " +
                "those creatures gain +1/+0 until end of turn.";
    }
}

class DroneSevenOfNineFilter extends FilterAttackingCreature {

    public DroneSevenOfNineFilter() {
        super("creatures attacking you");
    }

    public DroneSevenOfNineFilter(final DroneSevenOfNineFilter filter) {
        super(filter);
    }

    @Override
    public DroneSevenOfNineFilter copy() {
        return new DroneSevenOfNineFilter(this);
    }

    @Override
    public boolean match(Permanent permanent, UUID sourceId, UUID playerId, Game game) {
        if (!super.match(permanent, sourceId, playerId, game)) {
            return false;
        }

        for (CombatGroup group : game.getCombat().getGroups()) {
            for (UUID attacker : group.getAttackers()) {
                if (attacker.equals(permanent.getId())) {
                    UUID defenderId = group.getDefenderId();
                    if (defenderId.equals(playerId)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}