
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DontUntapInControllersUntapStepAllEffect;
import mage.abilities.effects.common.TapTargetEffect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.counters.CounterType;
import mage.filter.common.FilterCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author amcomeau
 */
public final class AenarSpeakerLissan extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("creatures with ice counters");

    static {
        filter.add(CounterType.ICE.getPredicate());
    }

    public AenarSpeakerLissan(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{S}{S}{U}{U}");

        this.addSuperType(SuperType.LEGENDARY);
        this.addSuperType(SuperType.SNOW);
        this.subtype.add(SubType.AENAR);
        this.subtype.add(SubType.LEADER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(6);

        // {2}{S}: Tap target creature and put an ice counter on it.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new TapTargetEffect("target creature"),
                new ManaCostsImpl("{2}{S}")
        );
        Effect effect = new AddCountersTargetEffect(CounterType.ICE.createInstance());
        effect.setText("and put an ice counter on it");
        ability.addEffect(effect);
        ability.addTarget(new TargetCreaturePermanent(1));
        this.addAbility(ability);

        // Creatures with ice counters on them don't untap during their controllers' untap steps.
        effect = new DontUntapInControllersUntapStepAllEffect(Duration.WhileOnBattlefield, TargetController.ANY, filter);
        effect.setText("Creatures with ice counters on them don't untap during their controllers' untap steps");
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, effect));

    }

    private AenarSpeakerLissan(final AenarSpeakerLissan card) {
        super(card);
    }

    @Override
    public AenarSpeakerLissan copy() {
        return new AenarSpeakerLissan(this);
    }
}
