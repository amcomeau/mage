
package mage.cards.i;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.RenownAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author amcomeau
 */

public final class ImmatureDrone extends CardImpl {

    public ImmatureDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{G}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);
        this.addAbility(new RenownAbility());

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

        // Renown 1 (When this creature deals combat damage to a player, if it isn't renowned, put a +1/+1 counter on it and it becomes renowned.)
        this.addAbility(new RenownAbility(1));
    }

    private ImmatureDrone(final ImmatureDrone card) {
        super(card);
    }

    @Override
    public ImmatureDrone copy() {
        return new ImmatureDrone(this);
    }
}
