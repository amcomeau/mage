package mage.cards.j;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.common.delayed.AtTheBeginOfNextEndStepDelayedTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.ReturnToBattlefieldUnderOwnerControlTargetEffect;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.continuous.BoostControlledEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetPermanent;
import mage.target.targetpointer.FixedTarget;

import java.util.UUID;

/**
 * @author Plopman
 */
public final class Jhamel extends CardImpl {

    private static final FilterPermanent filter1 = new FilterPermanent("another target permanent");

    static {
        filter.add(AnotherPredicate.instance);
    }

    private static final FilterCreaturePermanent filter2 = new FilterCreaturePermanent("Snow creatures");

    static {
        filter.add(SuperType.SNOW.getPredicate());
    }

    public Jhamel(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{S}{W}");
        this.subtype.add(SuperType.LEGENDARY);
        this.subtype.add(SuperType.SNOW);
        this.subtype.add(SubType.AENAR);
        this.subtype.add(SubType.TELEPATH);

        this.power = new MageInt(3);
        this.toughness = new MageInt(5);

        // When Jhamel enters the battlefield, exile another target permanent. Return that card to the battlefield under its owner's control at the beginning of the next end step.
        Ability ability = new EntersBattlefieldTriggeredAbility(new JhamelEffect());
        ability.addTarget(new TargetPermanent(filter1));
        this.addAbility(ability);

        // {1}{S}: Snow creatures you control get +1/+1 until end of turn.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new BoostControlledEffect(1, 1,
            Duration.EndOfTurn, filter2), new ManaCostsImpl("{1}{S}")));
    }

    private Jhamel(final Jhamel card) {
        super(card);
    }

    @Override
    public Jhamel copy() {
        return new Jhamel(this);
    }
}

class JhamelEffect extends OneShotEffect {

    public JhamelEffect() {
        super(Outcome.Detriment);
        staticText = "exile another target permanent. Return that card to the battlefield under its owner's control at the beginning of the next end step";
    }

    public JhamelEffect(final JhamelEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent permanent = game.getPermanent(source.getFirstTarget());
        Player controller = game.getPlayer(source.getControllerId());
        Permanent sourcePermanent = game.getPermanentOrLKIBattlefield(source.getSourceId());
        if (controller != null && permanent != null && sourcePermanent != null) {
            if (controller.moveCardToExileWithInfo(permanent, source.getSourceId(), sourcePermanent.getIdName(), source, game, Zone.BATTLEFIELD, true)) {
                //create delayed triggered ability
                Effect effect = new ReturnToBattlefieldUnderOwnerControlTargetEffect(false, false);
                effect.setText("Return that card to the battlefield under its owner's control at the beginning of the next end step");
                effect.setTargetPointer(new FixedTarget(source.getFirstTarget(), game));
                game.addDelayedTriggeredAbility(new AtTheBeginOfNextEndStepDelayedTriggeredAbility(effect), source);
                return true;
            }
        }
        return false;
    }

    @Override
    public JhamelEffect copy() {
        return new JhamelEffect(this);
    }
}
