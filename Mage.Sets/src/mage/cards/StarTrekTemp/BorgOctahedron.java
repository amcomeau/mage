
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.keyword.CrewAbility;
import mage.abilities.effects.common.RegenerateSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;

/**
 *
 * @author amcomeau
 */

public final class BorgOctahedron extends CardImpl {

    private static final FilterPermanent filter = new FilterCreaturePermanent(SubType.BORG);

    public BorgOctahedron(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{3}");
        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(3);
        this.toughness = new MageInt(8);

        // Whenever Borg Octahedron attacks, target Borg gets +1/+1 until end of turn.
        Ability ability = new AttacksTriggeredAbility(new BoostTargetEffect(
                1, 1, Duration.EndOfTurn
        ), false);
        ability.addTarget(new TargetCreaturePermanent(filter));
        this.addAbility(ability);

        // {3}: Regenerate Borg Octahedron.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateSourceEffect(), new ManaCostsImpl("{3}")));

        // Crew 3
        this.addAbility(new CrewAbility(3));
    }

    private BorgOctahedron(final BorgOctahedron card) {
        super(card);
    }

    @Override
    public BorgOctahedron copy() {
        return new BorgOctahedron(this);
    }
}
