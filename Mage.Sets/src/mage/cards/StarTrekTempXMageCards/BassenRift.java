
package mage.cards.b;

import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.mana.BlackManaAbility;
import mage.abilities.mana.GreenManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

import java.util.UUID;

/**
 * @author amcomeau
 */

public final class BassenRift extends CardImpl {

    public BassenRift(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");
        this.subtype.add(SubType.NEBULA);

        // Golgari Guildgate enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {B} or {G}.
        this.addAbility(new BlackManaAbility());
        this.addAbility(new GreenManaAbility());
    }

    private BassenRift(final BassenRift card) {
        super(card);
    }

    @Override
    public BassenRift copy() {
        return new BassenRift(this);
    }
}
