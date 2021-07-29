package mage.sets;

import mage.cards.CardGraphicInfo;
import mage.cards.ExpansionSet;
import mage.cards.FrameStyle;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 *
 * @author amcomeau
 */
public final class StarTrek extends ExpansionSet {

    private static final StarTrek instance = new StarTrek();

    public static StarTrek getInstance() {
        return instance;
    }

    private StarTrek() {
        super("Star Trek", "ST:INTRO", ExpansionSet.buildDate(2021, 07, 15), SetType.CUSTOM_SET);
        this.blockName = "Star Trek: Intro";
        this.hasBoosters = true;
        this.hasBasicLands = true;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;

        cards.add(new SetCardInfo("Aenar Healer", X, Rarity.COMMON, mage.cards.a.AenarHealer.class));
        cards.add(new SetCardInfo("Aenar Speaker Lissan", X, Rarity.RARE, mage.cards.a.AenarSpeakerLissan.class));
        cards.add(new SetCardInfo("Ambassador Shras", X, Rarity.UNCOMMON, mage.cards.a.AmbassadorShras.class));
        cards.add(new SetCardInfo("Andorian Ale", X, Rarity.UNCOMMON, mage.cards.a.AndorianAle.class));
        cards.add(new SetCardInfo("Andorian Battle Cruiser", X, Rarity.COMMON, mage.cards.a.AndorianBattleCruiser.class));
        cards.add(new SetCardInfo("Andorian Captain", X, Rarity.COMMON, mage.cards.a.AndorianCaptain.class));
        cards.add(new SetCardInfo("Andorian Commandos", X, Rarity.COMMON, mage.cards.a.AndorianCommandos.class));
        cards.add(new SetCardInfo("Andorian Rifle", X, Rarity.COMMON, mage.cards.a.AndorianRifle.class));
        cards.add(new SetCardInfo("Annihilate", X, Rarity.UNCOMMON, mage.cards.a.Annihilate.class));
        cards.add(new SetCardInfo("Arachnid Nebula", X, Rarity.UNCOMMON, mage.cards.a.ArachnidNebula.class));
        cards.add(new SetCardInfo("Assassination Attempt", X, Rarity.UNCOMMON, mage.cards.a.AssassinationAttempt.class));
        cards.add(new SetCardInfo("Assimilate Crewman", X, Rarity.UNCOMMON, mage.cards.a.AssilimateCrewman.class));
        cards.add(new SetCardInfo("Assimilated Scientists", X, Rarity.COMMON, mage.cards.a.AssimilatedScientists.class));
        cards.add(new SetCardInfo("Assimilation Drone", X, Rarity.UNCOMMON, mage.cards.a.AssimilationDrone.class));
        cards.add(new SetCardInfo("Bassen Rift", X, Rarity.UNCOMMON, mage.cards.b.BassenRift.class));
        cards.add(new SetCardInfo("Battle Cruiser Kumari", X, Rarity.RARE, mage.cards.b.BattleCruiserKumari.class));
        cards.add(new SetCardInfo("Borg Cube", X, Rarity.UNCOMMON, mage.cards.b.BorgCube.class));
        cards.add(new SetCardInfo("Borg Nanoprobes", X, Rarity.UNCOMMON, mage.cards.b.BorgNanoprobes.class));
        cards.add(new SetCardInfo("Borg Octahedron", X, Rarity.RARE, mage.cards.b.BorgOctahedron.class));
        cards.add(new SetCardInfo("Borg Queen", X, Rarity.MYTHIC, mage.cards.b.BorgQueen.class));
        cards.add(new SetCardInfo("Borg Sphere", X, Rarity.COMMON, mage.cards.b.BorgSphere.class));
        cards.add(new SetCardInfo("Borg Tactical Cube", X, Rarity.MYTHIC, mage.cards.b.BorgTacticalCube.class));
        cards.add(new SetCardInfo("Central Plexus", X, Rarity.UNCOMMON, mage.cards.c.CentralPlexus.class));
        cards.add(new SetCardInfo("Commander Shran", X, Rarity.MYTHIC, mage.cards.c.CommanderShran.class));
        cards.add(new SetCardInfo("Continuous Adaptation", X, Rarity.UNCOMMON, mage.cards.c.ContinuousAdaptation.class));
        cards.add(new SetCardInfo("Crosis", X, Rarity.UNCOMMON, mage.cards.c.Crosis.class));
        cards.add(new SetCardInfo("Debt Repaid", X, Rarity.UNCOMMON, mage.cards.d.DebtRepaid.class));
        cards.add(new SetCardInfo("Disconnected Drone", X, Rarity.UNCOMMON, mage.cards.d.DisconnectedDrone.class));
        cards.add(new SetCardInfo("Doomed Reawakening", X, Rarity.COMMON, mage.cards.d.DoomedReawakening.class));
        cards.add(new SetCardInfo("Drone Magnus Hansen", X, Rarity.UNCOMMON, mage.cards.d.DroneMagnusHansen.class));
        cards.add(new SetCardInfo("Drone Seven of Nine", X, Rarity.RARE, mage.cards.d.DroneSevenOfNine.class));
        cards.add(new SetCardInfo("Gareb", X, Rarity.UNCOMMON, mage.cards.g.Gareb.class));
        cards.add(new SetCardInfo("Gun-Point Diplomacy", X, Rarity.UNCOMMON, mage.cards.g.GunPointDiplomacy.class));
        cards.add(new SetCardInfo("Hidden Entrance", X, Rarity.RARE, mage.cards.h.HiddenEntrance.class));
        cards.add(new SetCardInfo("Hostage Taking", X, Rarity.UNCOMMON, mage.cards.h.HostageTaking.class));
        cards.add(new SetCardInfo("Hugh", X, Rarity.UNCOMMON, mage.cards.h.Hugh.class));
        cards.add(new SetCardInfo("Ice-Bores", X, Rarity.COMMON, mage.cards.i.IceBores.class));
        cards.add(new SetCardInfo("Immature Drone", X, Rarity.COMMON, mage.cards.i.ImmatureDrone.class));
        cards.add(new SetCardInfo("Interrogation Room", X, Rarity.RARE, mage.cards.i.InterrogationRoom.class));
        cards.add(new SetCardInfo("Jhamel", X, Rarity.RARE, mage.cards.j.Jhamel.class));
        cards.add(new SetCardInfo("Locutus", X, Rarity.RARE, mage.cards.l.Locutus.class));
        cards.add(new SetCardInfo("Loved One Avenged", X, Rarity.UNCOMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("Lt. Talas", X, Rarity.UNCOMMON, mage.cards.l.LtTalas.class));
        cards.add(new SetCardInfo("Lt. Tarah", X, Rarity.UNCOMMON, mage.cards.l.LtTarah.class));
        cards.add(new SetCardInfo("Maintenance Drone", X, Rarity.COMMON, mage.cards.m.MaintenanceDrone.class));
        cards.add(new SetCardInfo("Medical Drone", X, Rarity.COMMON, mage.cards.m.MedicalDrone.class));
        cards.add(new SetCardInfo("Mindslaver", X, Rarity.MYTHIC, mage.cards.m.Mindslaver.class));
        cards.add(new SetCardInfo("Mutara Nebula", X, Rarity.UNCOMMON, mage.cards.m.MutaraNebula.class));
        cards.add(new SetCardInfo("Needle Fingers and Bill", X, Rarity.COMMON, mage.cards.n.NeedleFingersAndBill.class));
        cards.add(new SetCardInfo("Northern Wastes", X, Rarity.RARE, mage.cards.n.NorthernWastes.class));
        cards.add(new SetCardInfo("Precision Cutting", X, Rarity.COMMON, mage.cards.p.PrecisionCutting.class));
        cards.add(new SetCardInfo("Regeneration Alcove", X, Rarity.COMMON, mage.cards.r.RegenerationAlcove.class));
        cards.add(new SetCardInfo("Resistance is Futile", X, Rarity.RARE, mage.cards.r.ResistanceIsFutile.class));
        cards.add(new SetCardInfo("Reveal the Path", X, Rarity.UNCOMMON, mage.cards.r.RevealThePath.class));
        cards.add(new SetCardInfo("Robinson Nebula", X, Rarity.UNCOMMON, mage.cards.r.RobinsonNebula.class));
        cards.add(new SetCardInfo("Shrewd Negotiation", X, Rarity.UNCOMMON, mage.cards.s.ShrewdNegotiations.class));
        cards.add(new SetCardInfo("Snow-Covered Island", X, Rarity.COMMON, mage.cards.s.SnowCoveredIsland.class));
        cards.add(new SetCardInfo("Snow-Covered Mountain", X, Rarity.COMMON, mage.cards.s.SnowCoveredMountain.class));
        cards.add(new SetCardInfo("Snow-Covered Plains", X, Rarity.COMMON, mage.cards.s.SnowCoveredPlains.class));
        cards.add(new SetCardInfo("Stolen Prototype", X, Rarity.COMMON, mage.cards.s.StolenPrototype.class));
        cards.add(new SetCardInfo("Strength in Numbers", X, Rarity.RARE, mage.cards.s.StrengthInNumbers.class));
        cards.add(new SetCardInfo("Tactical Drone", X, Rarity.UNCOMMON, mage.cards.t.TacticalDrone.class));
        cards.add(new SetCardInfo("Transwarp Hub", X, Rarity.MYTHIC, mage.cards.t.TranswarpHub.class));
        cards.add(new SetCardInfo("Useless Shot", X, Rarity.COMMON, mage.cards.u.UselessShot.class));
        cards.add(new SetCardInfo("Ushaan Preparations", X, Rarity.UNCOMMON, mage.cards.u.UshaanPreparations.class));
        cards.add(new SetCardInfo("Ushaan", X, Rarity.COMMON, mage.cards.u.Ushaan.class));
        cards.add(new SetCardInfo("Ushaan-tor", X, Rarity.MYTHIC, mage.cards.u.UshaanTor.class));
        cards.add(new SetCardInfo("Utter Devastation", X, Rarity.RARE, mage.cards.u.UtterDevastation.class));

        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));
        cards.add(new SetCardInfo("", X, Rarity.COMMON, mage.cards.a.X.class));

        cards.add(new SetCardInfo("Forest", "X", Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
        cards.add(new SetCardInfo("Holodeck", "X", Rarity.LAND, mage.cards.h.Holodeck.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
        cards.add(new SetCardInfo("Island", "X", Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
        cards.add(new SetCardInfo("Mountain", "X", Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
        cards.add(new SetCardInfo("Plains", "X", Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
        cards.add(new SetCardInfo("Swamp", "X", Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(FrameStyle.ZEN_FULL_ART_BASIC, true)));
    }
}
