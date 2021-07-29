
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.Cost;
import mage.abilities.costs.VariableCost;
import mage.abilities.costs.VariableCostImpl;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.BoostAllEffect;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToHandEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.TargetController;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.game.permanent.token.BorgDroneToken;

/**
 *
 * @author amcomeau
 */

public final class BorgQueen extends CardImpl {

    private static final FilterCreaturePermanent filterBorg = new FilterCreaturePermanent("Borg you control");
    private static final FilterCreaturePermanent filterNonartifact = new FilterCreaturePermanent("nonartifact creature");

    static {
        filterBorg.add(SubType.BORG.getPredicate());
        filterBorg.add(TargetController.YOU.getControllerPredicate());
        filterNonartifact.add(Predicates.not(CardType.ARTIFACT.getPredicate()));
    }

    public BorgQueen(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}{B}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.QUEEN);
        this.power = new MageInt(2);
        this.toughness = new MageInt(5);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

        // Other Borg you control get +1/+1.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostAllEffect(1, 1, Duration.WhileOnBattlefield, filterBorg, true)));

        // {X}{B}: Assimilate target nonartifact creature that dealt combat damage to you this turn, where X is that creature's toughness.
        this.addEffect(new GainControlTargetEffect(Duration.Custom, true), new ManaCostsImpl("{int}{B}"), true);
        this.addEffect(new GainAbilityTargetEffect(DevoidAbility.getInstance()));
        this.addEffect(new BecomesCreatureTypeTargetEffect(Duration.WhileOnBattlefield, SubType.BORG, SubType.DRONE, false);

        // {B}{B}, {T}: Create a 2/2 Borg Drone creature token with devoid.
        Ability tokenAbility = new SimpleActivatedAbility(Zone.BATTLEFIELD, new CreateTokenEffect(new BorgDroneToken()), new ManaCostsImpl("{B}{B}"));
        tokenAbility.addCost(new TapSourceCost());
        this.addAbility(tokenAbility);

        // {2}{B}{B}: Return Borg Queen from your graveyard to your hand.
        this.addAbility(new SimpleActivatedAbility(Zone.GRAVEYARD, new ReturnSourceFromGraveyardToHandEffect(), new ManaCostsImpl("{2}{B}{B}")));

    }

    private BorgQueen(final BorgQueen card) {
        super(card);
    }

    @Override
    public BorgQueen copy() {
        return new BorgQueen(this);
    }
}
