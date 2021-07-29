package mage.cards.u;

import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.AttackingCreatureCount;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.continuous.BoostEquippedEffect;
import mage.abilities.effects.common.continuous.GainAbilityAttachedEffect;
import mage.abilities.effects.common.cost.SpellCostReductionForEachSourceEffect;
import mage.abilities.hint.ValueHint;
import mage.abilities.keyword.DoubleStrikeAbility;
import mage.abilities.keyword.EquipAbility;
import mage.abilities.keyword.FlashAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.filter.StaticFilters;
import mage.filter.predicate.Predicates;
import mage.target.common.TargetControlledCreaturePermanent;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class UshaanTor extends CardImpl {

    private static final TargetControlledCreaturePermanent filter = new TargetControlledCreaturePermanent("non-Starship creature");

    static {
        filter.add(Predicates.not(CardType.STARSHIP.getPredicate()));
    }

    public UshaanTor(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{4}{S}{R}");

        this.addSuperType(SuperType.LEGENDARY);
        this.addSuperType(SuperType.SNOW);
        this.subtype.add(SubType.EQUIPMENT);

        // Flash
        this.addAbility(FlashAbility.getInstance());

        // This spell costs {1} less to cast for each attacking creature you control.
        DynamicValue xValue = new AttackingCreatureCount(StaticFilters.FILTER_PERMANENT_CREATURE_CONTROLLED);
        this.addAbility(new SimpleStaticAbility(Zone.ALL,
                new SpellCostReductionForEachSourceEffect(1, xValue)
        ).addHint(new ValueHint("Attacking creature you control", xValue)));

        // When Ushaan-tor enters the battlefield, attach it to target non-Starship creature you control.
        Ability ability = new EntersBattlefieldTriggeredAbility(new AttachEffect(
                Outcome.BoostCreature, "attach it to target creature you control"
        ), false);
        ability.addTarget(new TargetControlledCreaturePermanent(filter));
        this.addAbility(ability);

        // Equipped creature gets +1/+1 and has double strike and trample.
        ability = new SimpleStaticAbility(new BoostEquippedEffect(1, 1));
        ability.addEffect(new GainAbilityAttachedEffect(
                DoubleStrikeAbility.getInstance(), AttachmentType.EQUIPMENT
        ).setText("and has double strike"));
        ability.addEffect(new GainAbilityAttachedEffect(
                TrampleAbility.getInstance(), AttachmentType.EQUIPMENT
        ).setText("and trample"));
        this.addAbility(ability);

        // Equip non-Starship creature {3}
        this.addAbility(new EquipAbility(3), filter);
    }

    private UshaanTor(final UshaanTor card) {
        super(card);
    }

    @Override
    public UshaanTor copy() {
        return new UshaanTor(this);
    }
}
