package mage.cards.a;

import mage.MageInt;
import mage.abilities.keyword.CrewAbility;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

import java.util.UUID;

/**
 * @author amcomeau
 */

public final class AndorianBattleCruiser extends CardImpl {

    public AndorianBattleCruiser(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{2}");

        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // First strike
        this.addAbility(FirstStrikeAbility.getInstance());

        // Crew 1
        this.addAbility(new CrewAbility(1));
    }

    private AndorianBattleCruiser(final AndorianBattleCruiser card) {
        super(card);
    }

    @Override
    public AndorianBattleCruiser copy() {
        return new AndorianBattleCruiser(this);
    }
}
