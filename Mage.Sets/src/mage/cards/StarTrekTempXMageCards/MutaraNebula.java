
package mage.cards.m;

import java.util.UUID;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.mana.BlueManaAbility;
import mage.abilities.mana.RedManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 * @author amcomeau
 */
public final class MutaraNebula extends CardImpl {

    public MutaraNebula(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");
        this.subtype.add(SubType.NEBULA);

        // Mutara Nebula enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());

        // {T}: Add {U} or {R}.
        this.addAbility(new RedManaAbility());
        this.addAbility(new BlueManaAbility());
    }

    private MutaraNebula(final MutaraNebula card) {
        super(card);
    }

    @Override
    public MutaraNebula copy() {
        return new MutaraNebula(this);
    }
}
