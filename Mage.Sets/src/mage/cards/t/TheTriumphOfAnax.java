package mage.cards.t;

import mage.abilities.common.SagaAbility;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.CountersSourceCount;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.Effects;
import mage.abilities.effects.common.FightTargetsEffect;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.counters.CounterType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.ControllerPredicate;
import mage.target.TargetPermanent;
import mage.target.Targets;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class TheTriumphOfAnax extends CardImpl {

    private static final DynamicValue xValue = new CountersSourceCount(CounterType.LORE);
    private static final FilterPermanent filter = new FilterCreaturePermanent("creature you don't control");

    static {
        filter.add(new ControllerPredicate(TargetController.NOT_YOU));
    }

    public TheTriumphOfAnax(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{2}{R}");

        this.subtype.add(SubType.SAGA);

        // (As this Saga enters and after your draw step, add a lore counter. Sacrifice after IV.)
        SagaAbility sagaAbility = new SagaAbility(this, SagaChapter.CHAPTER_IV);

        // I, II, III — Until end of turn, target creature gains trample and gets +X/+0, where X is the number of lore counters on The Triumph of Anax.
        sagaAbility.addChapterEffect(
                this, SagaChapter.CHAPTER_I, SagaChapter.CHAPTER_III,
                new Effects(new GainAbilityTargetEffect(
                        TrampleAbility.getInstance(), Duration.EndOfTurn,
                        "Until end of turn, target creature gains trample"
                ), new BoostTargetEffect(
                        xValue, StaticValue.getZeroValue(), Duration.EndOfTurn, true
                ).setText("and gets +X/+0, where X is the number of lore counters on {this}")),
                new TargetCreaturePermanent()
        );

        // IV — Target creature you control fights up to one target creature you don't control.
        sagaAbility.addChapterEffect(
                this, SagaChapter.CHAPTER_IV, SagaChapter.CHAPTER_IV,
                new Effects(new FightTargetsEffect(
                        "Target creature you control fights up to one target creature you don't control"
                )), new Targets(
                        new TargetControlledCreaturePermanent(),
                        new TargetPermanent(0, 1, filter, false)
                )
        );
    }

    private TheTriumphOfAnax(final TheTriumphOfAnax card) {
        super(card);
    }

    @Override
    public TheTriumphOfAnax copy() {
        return new TheTriumphOfAnax(this);
    }
}