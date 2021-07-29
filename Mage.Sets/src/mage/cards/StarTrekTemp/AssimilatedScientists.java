
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author amcomeau
 */

public final class AssimilatedScientists extends CardImpl {

    public AssimilatedScientists(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{G}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(1);
        this.toughness = new MageInt(2);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
        // When Assimilated Scientists enters the battlefield, draw a card.
        this.addAbility(new EntersBattlefieldTriggeredAbility(new DrawCardSourceControllerEffect(1)));
    }

    private AssimilatedScientists(final AssimilatedScientists card) {
        super(card);
    }

    @Override
    public AssimilatedScientists copy() {
        return new AssimilatedScientists(this);
    }
}
