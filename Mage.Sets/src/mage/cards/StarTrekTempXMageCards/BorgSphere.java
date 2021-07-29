
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.CrewAbility;
import mage.abilities.effects.common.RegenerateSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;

/**
 *
 * @author amcomeau
 */

public final class BorgSphere extends CardImpl {

    public BorgSphere(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{3}");
        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // {3}: Regenerate Borg Sphere.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateSourceEffect(), new ManaCostsImpl("{3}")));

        // Crew 2
        this.addAbility(new CrewAbility(2));
    }

    private BorgSphere(final BorgSphere card) {
        super(card);
    }

    @Override
    public BorgSphere copy() {
        return new BorgSphere(this);
    }
}
