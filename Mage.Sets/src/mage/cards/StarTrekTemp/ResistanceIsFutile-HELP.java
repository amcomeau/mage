

package mage.cards.r;

import java.util.UUID;
import mage.abilities.effects.common.continuous.BecomesCreatureTypeTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.effects.common.continuous.GainControlTargetEffect;
import mage.abilities.effects.Effect;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.target.TargetCreaturePermanent;

/**
 *
 * @author amcomeau
 */

public final class ResistanceIsFutile extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("nonartifact creature");

    static {
        filter.add(Predicates.not(CardType.ARTIFACT.getPredicate()));
    }

    public ResistanceIsFutile(UUID ownerId, CardSetInfo setInfo){
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{2}{B}{B}");

        // Assimilate target nonartifact creature. (Gain control of that nonartifact creature. It becomes a Borg Drone with devoid in addition to its other types.)
        this.getSpellAbility().addEffect(new GainControlTargetEffect(Duration.Custom, true));
        this.getSpellAbility().addTarget(new TargetCreaturePermanent(filter));
        this.getSpellAbility().addEffect(new GainAbilityTargetEffect(DevoidAbility.getInstance()));
        this.getSpellAbility().addEffect(new BecomesCreatureTypeTargetEffect(Duration.WhileOnBattlefield, SubType.BORG, SubType.DRONE, false);

    }

    private ResistanceIsFutile(final ResistanceIsFutile card) {
        super(card);
    }

    @Override
    public ResistanceIsFutile copy() {
        return new ResistanceIsFutile(this);
    }
}
