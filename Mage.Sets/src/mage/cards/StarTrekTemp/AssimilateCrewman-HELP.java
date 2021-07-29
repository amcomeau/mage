package mage.cards.a;

import mage.abilities.effects.common.ReturnFromGraveyardToBattlefieldTargetEffect;
import mage.abilities.effects.common.continuous.BecomesCreatureTypeTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.Devoid;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.target.TargetPermanent;
import mage.target.common.TargetCardInOpponentsGraveyard;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class AssimilateCrewman extends CardImpl {

    private static final FilterPermanent filter = new FilterCreaturePermanent("nonartifact creature");

    static {
        filter.add(Predicates.not(CardType.ARTIFACT.getPredicate()));
    }

    public AssimilateCrewman(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{3}{B}");

        // Put target nonartifact creature card from an opponent's graveyard onto the battlefield under your control. It becomes a Borg Drone with devoid instead of its original colors and types.
        this.getSpellAbility().addTarget(new TargetCardInOpponentsGraveyard(new FilterCreaturePermanent()));
        this.getSpellAbility().addEffect(new ReturnFromGraveyardToBattlefieldTargetEffect());
        this.getSpellAbility().addEffect(new GainAbilityTargetEffect(DevoidAbility.getInstance()));
        this.getSpellAbility().addEffect(new BecomesCreatureTypeTargetEffect(Duration.WhileOnBattlefield, SubType.BORG, SubType.DRONE, false);
    }

    private AssimilateCrewman(final AssimilateCrewman card) {
        super(card);
    }

    @Override
    public AssimilateCrewman copy() {
        return new AssimilateCrewman(this);
    }
}
