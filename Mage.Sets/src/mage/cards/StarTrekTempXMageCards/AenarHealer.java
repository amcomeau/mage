
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.GainLifeEffect;
import mage.abilities.effects.common.UntapTargetEffect;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.filter.FilterPermanent;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */
public final class AenarHealer extends CardImpl {

    public AenarHealer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{S}{W}{U}");

        this.addSuperType(SuperType.SNOW);
        this.subtype.add(SubType.AENAR);
        this.subtype.add(SubType.DOCTOR);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // {S}, {T}: You gain 2 life.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new GainLifeEffect(2), new ManaCostsImpl("{S}"));
        ability.addCost(new TapSourceCost());
        this.addAbility(ability);

        // {T}: Untap another target snow permanent.
        Ability ability = new SimpleActivatedAbility(new UntapTargetEffect(), new TapSourceCost());
        ability.addTarget(new TargetPermanent(filter));
        this.addAbility(ability);
    }

    private AenarHealer(final AenarHealer card) {
        super(card);
    }

    @Override
    public AenarHealer copy() {
        return new AenarHealer(this);
    }
}
