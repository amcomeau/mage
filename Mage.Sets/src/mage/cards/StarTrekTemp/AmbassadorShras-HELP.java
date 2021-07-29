
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author amcomeau
 */

public final class AmbassadorShras extends CardImpl {

    public AmbassadorShras(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{U}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.AMBASSADOR);
        this.power = new MageInt(0);
        this.toughness = new MageInt(3);



    }

    private AmbassadorShras(final AmbassadorShras card) {
        super(card);
    }

    @Override
    public AmbassadorShras copy() {
        return new AmbassadorShras(this);
    }
}
