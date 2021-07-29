package mage.cards.b;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapTargetCost;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.CrewAbility;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.common.TargetControlledPermanent;

import java.util.UUID;

/**
 * @author amcomeau
 */

public final class BattleCruiserKumari extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledPermanent("untapped Andorian you control");

    static {
        filter.add(Predicates.not(TappedPredicate.instance));
        filter.add(SubType.ANDORIAN.getPredicate());
    }

    public BattleCruiserKumari(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{1}");

        this.supertype.add(SuperType.LEGENDARY);
        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // First strike
        this.addAbility(FirstStrikeAbility.getInstance());

        // Crew 1
        this.addAbility(new CrewAbility(1));

        // Tap an untapped Andorian you control: Battle Cruiser Kumari gets +1/+0 until end of turn.
        Effect effect = new BoostSourceEffect(1, 0, Duration.EndOfTurn);
        effect.setText("{this} gets +1/+0");
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, effect, new TapTargetCost(new TargetControlledPermanent(1, 1, filter, false)));
        ability.addEffect(effect);
        this.addAbility(ability);
    }

    private BattleCruiserKumari(final BattleCruiserKumari card) {
        super(card);
    }

    @Override
    public BattleCruiserKumari copy() {
        return new BattleCruiserKumari(this);
    }
}
