
package mage.cards.n;

import java.util.UUID;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.mana.SimpleManaAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SuperType;
import mage.constants.Zone;

/**
 * @author amcomeau
 */
public final class NorthernWastes extends CardImpl {

    public NorthernWastes(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");
        this.supertype.add(SuperType.LEGENDARY);
        this.supertype.add(SuperType.SNOW);

        // Northern Wastes enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {C}{C}.
        this.addAbility(new SimpleManaAbility(Zone.BATTLEFIELD, Mana.ColorlessMana(2), new TapSourceCost()));
    }

    private NorthernWastes(final NorthernWastes card) {
        super(card);
    }

    @Override
    public NorthernWastes copy() {
        return new NorthernWastes(this);
    }
}
