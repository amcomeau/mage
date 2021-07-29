
package mage.cards.a;

import java.util.UUID;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.effects.common.continuous.BoostOpponentsEffect;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Zone;

/**
 *
 * @author amcomeau
 */
public final class AndorianAle extends CardImpl {

    public AndorianAle(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{4}");


        // Creatures your opponents control get -1/-0.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostOpponentsEffect(-1, 0, Duration.WhileOnBattlefield)));

        // {U}, Sacrifice Andorian Ale: Draw a card.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DrawCardSourceControllerEffect(1), new ManaCostsImpl("{U}"));
        ability.addCost(new SacrificeSourceCost());
        this.addAbility(ability);

    }

    private AndorianAle(final AndorianAle card) {
        super(card);
    }

    @Override
    public AndorianAle copy() {
        return new AndorianAle(this);
    }
}
