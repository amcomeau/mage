
package mage.cards.r;

import java.util.UUID;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.mana.WhiteManaAbility;
import mage.abilities.mana.RedManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 * @author amcomeau
 */
public final class RobinsonNebula extends CardImpl {

    public RobinsonNebula(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");
        this.subtype.add(SubType.NEBULA);

        // Robinson Nebula enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {R} or {W}.
        this.addAbility(new RedManaAbility());
        this.addAbility(new WhiteManaAbility());
    }

    private RobinsonNebula(final RobinsonNebula card) {
        super(card);
    }

    @Override
    public RobinsonNebula copy() {
        return new RobinsonNebula(this);
    }
}
