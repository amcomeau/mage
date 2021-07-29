
package mage.cards.h;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.ExaltedAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author amcomeau
 */

public final class Hugh extends CardImpl {

    public Hugh(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{G}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);
        this.addAbility(new ExaltedAbility());

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

    }

    private Hugh(final Hugh card) {
        super(card);
    }

    @Override
    public Hugh copy() {
        return new Hugh(this);
    }
}
