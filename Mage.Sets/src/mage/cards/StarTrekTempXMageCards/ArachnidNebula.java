
package mage.cards.a;

import java.util.UUID;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.mana.BlueManaAbility;
import mage.abilities.mana.WhiteManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 * @author amcomeau
 */
public final class ArachnidNebula extends CardImpl {

    public ArachnidNebula(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");
        this.subtype.add(SubType.NEBULA);

        // Arachnid Nebula enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {W} or {U}.
        this.addAbility(new WhiteManaAbility());
        this.addAbility(new BlueManaAbility());
    }

    private ArachnidNebula(final ArachnidNebula card) {
        super(card);
    }

    @Override
    public ArachnidNebula copy() {
        return new ArachnidNebula(this);
    }
}
