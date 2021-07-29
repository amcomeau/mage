
package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.MenaceAbility;
import mage.abilities.keyword.ProtectionAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;

/**
 *
 * @author amcomeau
 */

public final class Locutus extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("federation creatures");  
    
    static {filter.add(SuperType.FEDERATION.getPredicate());
            filterDestroy.add(SuperType.FEDERATION.getPredicate());
    }

    public Locutus(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

        // Menace
        this.addAbility(new MenaceAbility());

        // Protection from federation creatures
        this.addAbility(new ProtectionAbility(filter));
    }

    private Locutus(final Locutus card) {
        super(card);
    }

    @Override
    public Locutus copy() {
        return new Locutus(this);
    }
}
