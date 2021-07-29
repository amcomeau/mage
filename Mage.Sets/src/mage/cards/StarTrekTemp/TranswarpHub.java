
package mage.cards.t;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.CompoundAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.*;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.filter.common.FilterControlledArtifactPermanent;

/**
 *
 * @author amcomeau
 */
public final class TranswarpHub extends CardImpl {

    private static final FilterControlledArtifactPermanent filter = new FilterControlledArtifactPermanent("Starships");

    static {
        filter.add(SubType.STARSHIP.getPredicate());
    }

    public TranswarpHub(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{5}");
        addSuperType(SuperType.LEGENDARY);

        // Starships you control have flash, first strike, and haste.
        CompoundAbility compoundAbilities = new CompoundAbility(FlashAbility.getInstance(), FirstStrikeAbility.getInstance(), HasteAbility.getInstance());
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new GainAbilityControlledEffect(compoundAbilities, Duration.WhileOnBattlefield, filter)));
    }

    private TranswarpHub(final TranswarpHub card) {
        super(card);
    }

    @Override
    public TranswarpHub copy() {
        return new TranswarpHub(this);
    }
}
