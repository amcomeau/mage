
package mage.cards.b;

import java.util.UUID;
import mage.abilities.Mode;
import mage.abilities.effects.common.RegenerateAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author amcomeau
 */

public final class BorgNanoprobes extends CardImpl {

    public BorgNanoprobes(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{1}{G}");

        // Regenerate each creature you control.
        mode = new Mode();
        mode.addEffect(new RegenerateAllEffect(new FilterControlledCreaturePermanent()));
        this.getSpellAbility().addMode(mode);
    }

    private BorgNanoprobes(final BorgNanoprobes card) {
        super(card);
    }

    @Override
    public BorgNanoprobes copy() {
        return new BorgNanoprobes(this);
    }
}
