
package mage.cards.a;

import java.util.UUID;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.target.Target;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */

public final class Annihilate extends CardImpl {

    public Annihilate(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{1}{B}{G}");

        // Destroy target permanent. It can't be regenerated.
        Mode mode = new Mode();
        mode.addEffect(new DestroyTargetEffect(true));
        mode.addTarget(new TargetPermanent(filter));
        this.getSpellAbility().addMode(mode);

    }

    private Annihilate(final Annihilate card) {
        super(card);
    }

    @Override
    public Annihilate copy() {
        return new Annihilate(this);
    }
}
