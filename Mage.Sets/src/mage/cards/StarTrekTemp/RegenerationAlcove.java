
package mage.cards.r;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.GainLifeEffect;
import mage.abilities.effects.common.RegenerateTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */
public final class RegenerationAlcove extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent(SubType.BORG, "Borg");

    public RegenerationAlcove(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{3}{G}");

	   // {2},{T}: Gain 2 life.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new GainLifeEffect(2), new GenericManaCost(2));
        ability.addCost(new TapSourceCost());
        this.addAbility(ability);

        // {tap}: Regenerate target Borg.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateTargetEffect(), new TapSourceCost());
        ability.addTarget(new TargetPermanent(filter));
        this.addAbility(ability);

    }

    private RegenerationAlcove(final RegenerationAlcove card) {
        super(card);
    }

    @Override
    public RegenerationAlcove copy() {
        return new RegenerationAlcove(this);
    }
}
