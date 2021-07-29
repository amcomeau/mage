
package mage.cards.m;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.common.RegenerateTargetEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */

public final class MedicalDrone extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent(SubType.BORG, "Borg");

    public MedicalDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{G}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(1);
        this.toughness = new MageInt(3);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
        // {tap}: Regenerate target Borg.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateTargetEffect(), new TapSourceCost());
        ability.addTarget(new TargetPermanent(filter));
        this.addAbility(ability);

    }

    private MedicalDrone(final MedicalDrone card) {
        super(card);
    }

    @Override
    public MedicalDrone copy() {
        return new MedicalDrone(this);
    }
}
