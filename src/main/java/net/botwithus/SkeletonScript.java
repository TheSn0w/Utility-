package net.botwithus;

import net.botwithus.api.game.hud.inventories.Backpack;
import net.botwithus.api.game.hud.inventories.Equipment;
import net.botwithus.rs3.game.minimenu.MiniMenu;
import net.botwithus.internal.scripts.ScriptDefinition;
import net.botwithus.rs3.game.Client;
import net.botwithus.rs3.game.Coordinate;
import net.botwithus.rs3.game.Item;
import net.botwithus.rs3.game.actionbar.ActionBar;
import net.botwithus.rs3.game.hud.interfaces.Component;
import net.botwithus.rs3.game.hud.interfaces.Interfaces;
import net.botwithus.rs3.game.js5.types.ItemType;
import net.botwithus.rs3.game.minimenu.actions.ComponentAction;
import net.botwithus.rs3.game.queries.builders.characters.NpcQuery;
import net.botwithus.rs3.game.queries.builders.components.ComponentQuery;
import net.botwithus.rs3.game.queries.builders.items.InventoryItemQuery;
import net.botwithus.rs3.game.queries.results.EntityResultSet;
import net.botwithus.rs3.game.queries.results.ResultSet;
import net.botwithus.rs3.game.scene.entities.characters.npc.Npc;
import net.botwithus.rs3.game.scene.entities.characters.player.LocalPlayer;
import net.botwithus.rs3.game.scene.entities.characters.player.Player;
import net.botwithus.rs3.game.skills.Skills;
import net.botwithus.rs3.game.vars.VarManager;
import net.botwithus.rs3.script.Execution;
import net.botwithus.rs3.script.LoopingScript;
import net.botwithus.rs3.script.ScriptConsole;
import net.botwithus.rs3.script.config.ScriptConfig;
import net.botwithus.rs3.util.RandomGenerator;

import java.time.Duration;
import java.time.Instant;

import static net.botwithus.rs3.game.Client.getLocalPlayer;
import static net.botwithus.rs3.game.scene.entities.characters.player.LocalPlayer.LOCAL_PLAYER;

public class SkeletonScript extends LoopingScript {
    boolean useThievingDummy;
    boolean UseDeathGrasp;
    boolean UseScriptureOfJas;
    boolean UseScriptureOfFul;
    boolean UseScriptureOfWen;
    boolean useExcalibur;
    boolean useAntifire;
    boolean useNecromancyPotion;
    private long targetLogoutTimeMillis = 0;
    boolean Logout;
    boolean useLightForm;
    boolean useSuperheatForm;
    boolean useCrystalMask;

    boolean usePenance;
    boolean useProtection;
    boolean KwuarmIncence;
    boolean TorstolIncence;
    boolean LantadymeIncence;
    boolean overloadEnabled;
    boolean useAgilityDummy;
    boolean useMagicDummy;
    boolean useRangedDummy;
    boolean useMeleeDummy;
    private boolean scriptRunning = false;
    long runStartTime;
    private int prayerPointsThreshold = 1000;
    private int healthThreshold = 50;
    private Instant scriptStartTime;
    boolean teleportToWarOnHealth;
    boolean useSaraBrew;
    boolean useSaraBrewandBlubber;
    boolean useoverload;
    boolean useprayer;
    boolean usedarkness;
    boolean useaggression;
    boolean usedivination;
    boolean usecooking;
    boolean UseSoulSplit;
    boolean useHunter;
    boolean quickprayer;
    boolean eatFood;
    boolean UseSmokeBomb;
    boolean UseVulnBomb;
    boolean InvokeDeath;
    private int startingAttackLevel;
    private int startingStrengthLevel;
    private int startingDefenseLevel;
    private int startingRangedLevel;
    private int startingPrayerLevel;
    private int startingMagicLevel;
    private int startingRunecraftingLevel;
    private int startingConstructionLevel;
    private int startingDungeoneeringLevel;
    private int startingArchaeologyLevel;
    private int startingConstitutionLevel;
    private int startingAgilityLevel;
    private int startingHerbloreLevel;
    private int startingThievingLevel;
    private int startingCraftingLevel;
    private int startingFletchingLevel;
    private int startingSlayerLevel;
    private int startingHunterLevel;
    private int startingDivinationLevel;
    private int startingNecromancyLevel;
    private int startingMiningLevel;
    private int startingSmithingLevel;
    private int startingFishingLevel;
    private int startingCookingLevel;
    private int startingFiremakingLevel;
    private int startingWoodcuttingLevel;
    private int startingFarmingLevel;
    private int startingSummoningLevel;
    private int startingInventionLevel;

    public int getStartingAttackLevel() {
        return startingAttackLevel;
    }

    public int getStartingStrengthLevel() {
        return startingStrengthLevel;
    }

    public int getStartingDefenseLevel() {
        return startingDefenseLevel;
    }

    public int getStartingRangedLevel() {
        return startingRangedLevel;
    }

    public int getStartingPrayerLevel() {
        return startingPrayerLevel;
    }

    public int getStartingMagicLevel() {
        return startingMagicLevel;
    }

    public int getStartingRunecraftingLevel() {
        return startingRunecraftingLevel;
    }

    public int getStartingConstructionLevel() {
        return startingConstructionLevel;
    }

    public int getStartingDungeoneeringLevel() {
        return startingDungeoneeringLevel;
    }

    public int getStartingArchaeologyLevel() {
        return startingArchaeologyLevel;
    }

    public int getStartingConstitutionLevel() {
        return startingConstitutionLevel;
    }

    public int getStartingAgilityLevel() {
        return startingAgilityLevel;
    }

    public int getStartingHerbloreLevel() {
        return startingHerbloreLevel;
    }

    public int getStartingThievingLevel() {
        return startingThievingLevel;
    }

    public int getStartingCraftingLevel() {
        return startingCraftingLevel;
    }

    public int getStartingFletchingLevel() {
        return startingFletchingLevel;
    }

    public int getStartingSlayerLevel() {
        return startingSlayerLevel;
    }

    public int getStartingHunterLevel() {
        return startingHunterLevel;
    }

    public int getStartingDivinationLevel() {
        return startingDivinationLevel;
    }

    public int getStartingNecromancyLevel() {
        return startingNecromancyLevel;
    }

    public int getStartingMiningLevel() {
        return startingMiningLevel;
    }

    public int getStartingSmithingLevel() {
        return startingSmithingLevel;
    }

    public int getStartingFishingLevel() {
        return startingFishingLevel;
    }

    public int getStartingCookingLevel() {
        return startingCookingLevel;
    }

    public int getStartingFiremakingLevel() {
        return startingFiremakingLevel;
    }

    public int getStartingWoodcuttingLevel() {
        return startingWoodcuttingLevel;
    }

    public int getStartingFarmingLevel() {
        return startingFarmingLevel;
    }

    public int getStartingSummoningLevel() {
        return startingSummoningLevel;
    }

    public int getStartingInventionLevel() {
        return startingInventionLevel;
    }



    public SkeletonScript(String s, ScriptConfig scriptConfig, ScriptDefinition scriptDefinition) {
        super(s, scriptConfig, scriptDefinition);
        this.sgc = new SkeletonScriptGraphicsContext(getConsole(), this);
        if (Client.getGameState() == Client.GameState.LOGGED_IN) {
            setupStartingSkillLevels();
        }
        super.initialize();
        this.isBackgroundScript = true;
        this.loopDelay = RandomGenerator.nextInt(1000, 1200);
        this.sgc = new SkeletonScriptGraphicsContext(getConsole(), this);
        this.runStartTime = System.currentTimeMillis();
    }

    public void startScript() {
        println("Attempting to start script...");
        if (!scriptRunning) {
            scriptRunning = true;
            scriptStartTime = Instant.now();
            println("Script started at: " + scriptStartTime);
        } else {
            println("Attempted to start script, but it is already running.");
        }
    }

    public void stopScript() {
        if (scriptRunning) {
            scriptRunning = false;
            Instant stopTime = Instant.now();
            println("Script stopped at: " + stopTime);
            long duration = Duration.between(scriptStartTime, stopTime).toMillis();
            println("Script ran for: " + duration + " milliseconds.");
        } else {
            println("Attempted to stop script, but it is not running.");
        }
    }
    private boolean hasUsedInvokeDeath = false;

    @Override
    public void onLoop() {
        if (getLocalPlayer() != null && Client.getGameState() == Client.GameState.LOGGED_IN && !scriptRunning) {
            return;
        }
        if (Logout)
            checkAndPerformLogout();
        if (useprayer)
            usePrayerOrRestorePots();
        if (useoverload)
            drinkOverloads();
        if (UseSoulSplit)
            manageSoulSplit();
        if (useaggression)
            useAggression();
        if (usecooking)
            useCooking();
        if (usedivination)
            useDivination();
        if (useHunter)
            useHunter();
        if (usedarkness)
            useDarkness();
        if (quickprayer)
            manageQuickPrayers();
        if (eatFood)
            eatFood();
        if (UseSmokeBomb)
            UseSmokeCloud();
        if (UseVulnBomb)
            useVulnBomb();
        if (InvokeDeath)
            Deathmark();
        if (useSaraBrew)
            UseSaraBrew();
        if (useSaraBrewandBlubber)
            UseSaraandBlubber();
        if (teleportToWarOnHealth)
            TeleportToWarOnHealth();
        if (useThievingDummy)
            UseThievingDummy();
        if (useAgilityDummy)
            UseAgilityDummy();
        if (useMagicDummy)
            UseMagicDummy();
        if (useRangedDummy)
            UseRangedDummy();
        if (useMeleeDummy)
            UseMeleeDummy();
        if (KwuarmIncence)
            KwuarmincenceSticks();
        if (TorstolIncence)
            TorstolIncenseSticks();
        if (LantadymeIncence)
            LantadymeIncenseSticks();
        if (usePenance)
            Penance();
        if (useProtection)
            Protection();
        if (useLightForm)
            LightFormActivation();
        if (!useLightForm)
            deactivateLightForm();
        if (useCrystalMask)
            CystalMask();
        if (useSuperheatForm)
            SuperheatFormActivation();
        if (!useSuperheatForm)
            deactivateSuperheatForm();
        if (useNecromancyPotion)
            NecromancyPotion();
        if (useAntifire)
            antifirePotion();
        if (useExcalibur)
            activateExcalibur();
        if (UseScriptureOfWen)
            manageScriptureOfWen();
        if (UseScriptureOfJas)
            manageScriptureOfJas();
        if (UseScriptureOfFul)
            manageScriptureOfFul();
    }

    public void setPrayerPointsThreshold(int threshold) {
        this.prayerPointsThreshold = threshold;
    }

    public void setHealthThreshold(int healthThreshold) {
        this.healthThreshold = healthThreshold;
    }

    public void usePrayerOrRestorePots() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            int currentPrayerPoints = LocalPlayer.LOCAL_PLAYER.getPrayerPoints();
            println("Current Prayer Points: " + currentPrayerPoints);
            if (currentPrayerPoints < prayerPointsThreshold) {
                ResultSet<Item> items = InventoryItemQuery.newQuery(93).results();

                Item prayerOrRestorePot = items.stream()
                        .filter(item -> item.getName() != null &&
                                (item.getName().toLowerCase().contains("prayer") ||
                                        item.getName().toLowerCase().contains("restore")))
                        .findFirst()
                        .orElse(null);

                if (prayerOrRestorePot != null) {
                    println("Drinking " + prayerOrRestorePot.getName());
                    boolean success = Backpack.interact(prayerOrRestorePot.getName(), "Drink");
                    Execution.delay(RandomGenerator.nextInt(1600, 2100));

                    if (!success) {
                        println("Failed to use " + prayerOrRestorePot.getName());
                    }
                } else {
                    println("No Prayer or Restore pots found.");
                }
            } else {
                println("Current Prayer points are above " + prayerPointsThreshold + " No need to use Prayer or Restore pot.");
            }
        }
    }


    public void drinkOverloads() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null && !localPlayer.isMoving()) {
            if (VarManager.getVarbitValue(26037) == 0) {
                if (localPlayer.getAnimationId() == 18000) {
                    return;
                }

                ResultSet<Item> overload = InventoryItemQuery.newQuery()
                        .name("overload", String::contains)
                        .results();
                if (!overload.isEmpty()) {
                    Item overloadItem = overload.first();
                    assert overloadItem != null;
                    Backpack.interact(overloadItem.getName(), "Drink");
                    println("Drinking overload " + overloadItem.getName() + " ID: " + overloadItem.getId());
                    Execution.delay(RandomGenerator.nextInt(10, 20));
                }
            }
        }
    }

    private boolean isAggressionActive() {
        Component aggressionIndicator = ComponentQuery.newQuery(284).spriteId(37969).results().first();
        return aggressionIndicator != null;
    }

    private void useAggression() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (!isAggressionActive()) {
                ResultSet<Item> results = InventoryItemQuery.newQuery(93)
                        .name("Aggression", String::contains)
                        .option("Drink")
                        .results();
                if (!results.isEmpty()) {
                    Item aggressionFlask = results.first();
                    if (aggressionFlask != null) {
                        boolean success = Backpack.interact(aggressionFlask.getName(), "Drink");
                        if (success) {
                            println("Using aggression potion: " + aggressionFlask.getName());
                        } else {
                            println("Failed to use aggression potion: " + aggressionFlask.getName());
                        }
                        Execution.delay(RandomGenerator.nextInt(2000, 3000));
                    }
                } else {
                    println("No aggression flasks found.");
                }
            } else {
                println("Aggression is already active.");
            }
        }
    }

    private boolean soulSplitActive = false;

    public void manageSoulSplit() {
        if (LOCAL_PLAYER.inCombat() && !soulSplitActive) {
            updateSoulSplitActivation();
        } else if (!LOCAL_PLAYER.inCombat() && soulSplitActive) {
            updateSoulSplitActivation();
        }
    }

    private void updateSoulSplitActivation() {
        int soulSplitEnabled = VarManager.getVarbitValue(16779);
        boolean shouldBeActive = shouldActivateSoulSplit();

        if (shouldBeActive && soulSplitEnabled != 1) {
            activateSoulSplit();
        } else if (!shouldBeActive && soulSplitEnabled == 1) {
            deactivateSoulSplit();
        }
    }

    private void activateSoulSplit() {
        if (!soulSplitActive) {
            println("Activating Soul Split.");
            if (ActionBar.useAbility("Soul Split")) {
                println("Soul Split activated successfully.");
                soulSplitActive = true;
            } else {
                println("Failed to activate Soul Split.");
            }
        }
    }

    private void deactivateSoulSplit() {
        if (soulSplitActive) {
            println("Deactivating Soul Split.");
            if (ActionBar.useAbility("Soul Split")) {
                println("Soul Split deactivated.");
                soulSplitActive = false;
            } else {
                println("Failed to deactivate Soul Split.");
            }
        }
    }

    private boolean shouldActivateSoulSplit() {
        return LOCAL_PLAYER.inCombat() && (UseSoulSplit);
    }

    private boolean isCookingActive() {
        Component cooking = ComponentQuery.newQuery(284).spriteId(49010).results().first();
        return cooking != null;
    }

    private void useCooking() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (!isCookingActive()) {
                ResultSet<Item> results = InventoryItemQuery.newQuery(93)
                        .name("cooking", String::contains)
                        .option("Drink")
                        .results();
                if (!results.isEmpty()) {
                    Item cookingItem = results.first();
                    if (cookingItem != null) {
                        boolean success = Backpack.interact(cookingItem.getName(), "Drink");
                        if (success) {
                            println("Using cooking potion: " + cookingItem.getName());
                        } else {
                            println("Failed to use cooking potion: " + cookingItem.getName());
                        }
                        Execution.delay(RandomGenerator.nextInt(2000, 3000));
                    }
                } else {
                    println("No Extreme cooking potions found.");
                }
            } else {
                println("Cooking boost is already active.");
            }
        }
    }

    private boolean isDivinationActive() {
        Component divination = ComponentQuery.newQuery(284).spriteId(44103).results().first();
        return divination != null;
    }

    private void useDivination() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (!isDivinationActive()) {
                ResultSet<Item> results = InventoryItemQuery.newQuery(93)
                        .name("divination", String::contains)
                        .option("Drink")
                        .results();
                if (!results.isEmpty()) {
                    Item divinationItem = results.first();
                    if (divinationItem != null) {
                        boolean success = Backpack.interact(divinationItem.getName(), "Drink");
                        if (success) {
                            println("Using divination potion: " + divinationItem.getName());
                        } else {
                            println("Failed to use divination potion: " + divinationItem.getName());
                        }
                        Execution.delay(RandomGenerator.nextInt(2000, 3000));
                    }
                } else {
                    println("No divination potions found.");
                }
            } else {
                println("Divination boost is already active.");
            }
        }
    }

    private boolean isHunterActive() {
        Component hunter = ComponentQuery.newQuery(284).spriteId(44127).results().first();
        return hunter != null;
    }

    private void useHunter() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (!isHunterActive()) {
                ResultSet<Item> results = InventoryItemQuery.newQuery(93)
                        .name("hunter", String::contains)
                        .option("Drink")
                        .results();
                if (!results.isEmpty()) {
                    Item hunterItem = results.first();
                    if (hunterItem != null) {
                        boolean success = Backpack.interact(hunterItem.getName(), "Drink");
                        if (success) {
                            println("Using hunter potion: " + hunterItem.getName());
                        } else {
                            println("Failed to use hunter potion: " + hunterItem.getName());
                        }
                        Execution.delay(RandomGenerator.nextInt(2000, 3000));
                    }
                } else {
                    println("No hunter potions found.");
                }
            } else {
                println("Hunter boost is already active.");
            }
        }
    }

    private boolean isDarknessActive() {
        Component darkness = ComponentQuery.newQuery(284).spriteId(30122).results().first();
        return darkness != null;
    }

    private void useDarkness() {
        if (getLocalPlayer() != null) {
            if (!isDarknessActive()) {
                ActionBar.useAbility("Darkness");
                println("Using darkness!");
                Execution.delay(RandomGenerator.nextInt(2000, 3000));
            }
        }
    }

    private boolean isQuickPrayersActive() {
        int[] varbitIds = {
                // Curses
                16761, 16762, 16763, 16786, 16764, 16765, 16787, 16788, 16765, 16766,
                16767, 16768, 16769, 16770, 16771, 16772, 16781, 16773, 16782, 16774,
                16775, 16776, 16777, 16778, 16779, 16780, 16784, 16783, 29065, 29066,
                29067, 29068, 29069, 49330, 29071, 34866, 34867, 34868, 53275, 53276,
                53277, 53278, 53279, 53280, 53281,
                // Normal
                16739, 16740, 16741, 16742, 16743, 16744, 16745, 16746, 16747, 16748,
                16749, 16750, 16751, 16752, 16753, 16754, 16755, 16756, 16757, 16758,
                16759, 16760, 53271, 53272, 53273, 53274
        };

        for (int varbitId : varbitIds) {
            if (VarManager.getVarbitValue(varbitId) == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean quickPrayersActive = false;

    public void manageQuickPrayers() {
        if (LOCAL_PLAYER.inCombat() && !quickPrayersActive) {
            updateQuickPrayersActivation();
        } else if (!LOCAL_PLAYER.inCombat() && quickPrayersActive) {
            updateQuickPrayersActivation();
        }
    }

    private void updateQuickPrayersActivation() {
        boolean isCurrentlyActive = isQuickPrayersActive();
        boolean shouldBeActive = shouldActivateQuickPrayers();

        if (shouldBeActive && !isCurrentlyActive) {
            activateQuickPrayers();
        } else if (!shouldBeActive && isCurrentlyActive) {
            deactivateQuickPrayers();
        }
    }

    private void activateQuickPrayers() {
        if (!quickPrayersActive) {
            println("Activating Quick Prayers.");
            if (ActionBar.useAbility("Quick-prayers 1")) {
                println("Quick Prayers activated successfully.");
                quickPrayersActive = true;
            } else {
                println("Failed to activate Quick Prayers.");
            }
        }
    }

    private void deactivateQuickPrayers() {
        if (quickPrayersActive) {
            println("Deactivating Quick Prayers.");
            if (ActionBar.useAbility("Quick-prayers 1")) {
                println("Quick Prayers deactivated.");
                quickPrayersActive = false;
            } else {
                println("Failed to deactivate Quick Prayers.");
            }
        }
    }

    private boolean shouldActivateQuickPrayers() {
        return LOCAL_PLAYER.inCombat();
    }

    public void eatFood() {
        if (getLocalPlayer() != null) {
            if (getLocalPlayer().getCurrentHealth() * 100 / getLocalPlayer().getMaximumHealth() < healthThreshold) {
                ResultSet<Item> food = InventoryItemQuery.newQuery(93).option("Eat").results();
                if (!food.isEmpty()) {
                    Item eat = food.first();
                    assert eat != null;
                    Backpack.interact(eat.getName(), 1);
                    println("Eating " + eat.getName());
                    Execution.delayUntil(RandomGenerator.nextInt(300, 500), () -> getLocalPlayer().getCurrentHealth() > 8000);
                } else {
                    println("No food found!");
                }
            }
        }
    }

    private void useVulnBomb() {
        if (UseVulnBomb) {
            if (getLocalPlayer() != null && getLocalPlayer().inCombat()) {
                if (getLocalPlayer().getTarget() != null) {
                    int vulnDebuffVarbit = VarManager.getVarbitValue(1939);
                    if (vulnDebuffVarbit == 0) { // 0 means debuff is not active
                        boolean success = ActionBar.useItem("Vulnerability bomb", "Throw");
                        if (success) {
                            println("Throwing Vulnerability bomb at " + getLocalPlayer().getTarget().getName());
                            Execution.delayUntil(RandomGenerator.nextInt(300, 500), () -> !getLocalPlayer().inCombat());
                        } else {
                            println("Failed to use Vulnerability bomb!");
                        }
                    } else {
                        println("Target already has the vulnerability debuff.");
                    }
                } else {
                    println("No target NPC found.");
                }
            }
        }
    }

    private void UseSmokeCloud() {
        if (UseSmokeBomb) {
            if (getLocalPlayer() != null && getLocalPlayer().inCombat()) {
                if (getLocalPlayer().getTarget() != null) {
                    int debuffVarbit = VarManager.getVarbitValue(49448);
                    if (debuffVarbit == 0) {
                        boolean abilityUsed = ActionBar.useAbility("Smoke Cloud");
                        if (abilityUsed) {
                            println("Used 'Smoke Cloud' on " + getLocalPlayer().getTarget().getName());
                        } else {
                            println("Failed to use 'Smoke Cloud'");
                        }
                    } else {
                        println(getLocalPlayer().getTarget().getName() + " already has the debuff.");
                    }
                } else {
                    println("No target NPC found.");
                }
            }
        }
    }

    private void Deathmark() {
        if (getLocalPlayer() == null) {
            return;
        }
        if (InvokeDeath && getLocalPlayer().hasTarget()) {

            ComponentQuery query = ComponentQuery.newQuery(1490).spriteId(30100);
            if (query.results().isEmpty()) {
                Execution.delay(RandomGenerator.nextInt(1000, 2000));
                ActionBar.useAbility("Invoke Death");
                println("Used Invoke Death");
                Execution.delayUntil(RandomGenerator.nextInt(60000, 120000), () -> getLocalPlayer().getTarget().getCurrentHealth() == 0);
                println("Target is dead, invoke death successful");
                Execution.delay(RandomGenerator.nextInt(1000, 2000));
            }
        }
    }


    private void UseSaraBrew() {
        if (useSaraBrew) {
            if (Client.getLocalPlayer() != null) {
                if (Client.getLocalPlayer().getCurrentHealth() * 100 / Client.getLocalPlayer().getMaximumHealth() < healthThreshold) {
                    ResultSet<Item> items = InventoryItemQuery.newQuery().results();

                    Item saraBrew = items.stream()
                            .filter(item -> item.getName() != null && item.getName().toLowerCase().contains("saradomin"))
                            .findFirst()
                            .orElse(null);

                    if (saraBrew != null) {
                        Backpack.interact(saraBrew.getName(), "Drink");
                        println("Drinking " + saraBrew.getName());
                        Execution.delayUntil(RandomGenerator.nextInt(1800, 2000), () -> {
                            LocalPlayer player = Client.getLocalPlayer();
                            if (player != null) {
                                double healthPercentage = (double) player.getCurrentHealth() / player.getMaximumHealth() * 100;
                                return healthPercentage > 90;
                            }
                            return false;
                        });
                    } else {
                        println("No Saradomin brews found!");
                    }
                }
            }
        }
    }

    private void UseSaraandBlubber() {
        if (useSaraBrewandBlubber) {
            LocalPlayer player = Client.getLocalPlayer();
            if (player != null) {
                double healthPercentage = (double) player.getCurrentHealth() / player.getMaximumHealth() * 100;
                if (healthPercentage < healthThreshold) {
                    ResultSet<Item> items = InventoryItemQuery.newQuery().results();

                    Item saraBrew = items.stream()
                            .filter(item -> item.getName() != null && item.getName().toLowerCase().contains("saradomin"))
                            .findFirst()
                            .orElse(null);

                    if (saraBrew != null) {
                        Backpack.interact(saraBrew.getName(), "Drink");
                        println("Drinking " + saraBrew.getName());
                    } else {
                        println("No Saradomin brews found!");
                    }

                    Item blubberItem = items.stream()
                            .filter(item -> item.getName() != null && item.getName().toLowerCase().contains("blubber"))
                            .findFirst()
                            .orElse(null);

                    if (blubberItem != null) {
                        Backpack.interact(blubberItem.getName(), "Eat");
                        println("Eating " + blubberItem.getName());
                    } else {
                        println("No blubber items found!");
                    }

                    Execution.delayUntil(RandomGenerator.nextInt(1800, 2000), () -> {
                        LocalPlayer currentPlayer = Client.getLocalPlayer();
                        if (currentPlayer != null) {
                            double currentHealthPercentage = (double) currentPlayer.getCurrentHealth() / currentPlayer.getMaximumHealth() * 100;
                            return currentHealthPercentage > 90;
                        }
                        return false;
                    });
                }
            }
        }
    }

    Coordinate coords = new Coordinate(3295, 10131, 0);
    int warsRetreatRegionId = coords.getRegionId();

    private void TeleportToWarOnHealth() {
        if (teleportToWarOnHealth) {
            LocalPlayer player = Client.getLocalPlayer();
            if (player != null) {
                double healthPercentage = (double) player.getCurrentHealth() / player.getMaximumHealth() * 100;
                if (healthPercentage < healthThreshold) {
                    ResultSet<Item> items = InventoryItemQuery.newQuery().results();

                    boolean hasHealingItem = items.stream().anyMatch(item -> {
                        if (item.getName() != null) {
                            if (item.getName().toLowerCase().contains("saradomin")) return true;
                            ItemType itemType = item.getConfigType();
                            if (itemType != null) {
                                return itemType.getBackpackOptions().contains("Eat");
                            }
                        }
                        return false;
                    });

                    if (!hasHealingItem) {
                        println("No food or Saradomin potions found in backpack. Attempting to teleport to War's Retreat due to low health.");
                        ActionBar.useAbility("War's Retreat Teleport");

                        Execution.delay(5000);

                        Coordinate currentPosition = Client.getLocalPlayer().getCoordinate();
                        int currentRegionId = currentPosition.getRegionId();
                        if (currentRegionId == warsRetreatRegionId) {
                            println("Teleport successful, player is now in War's Retreat region.");
                            stopScript();
                        }
                    }
                }
            }
        }
    }

    private void UseThievingDummy() {
        if (useThievingDummy) {
            EntityResultSet<Npc> results = NpcQuery.newQuery().name("Thieving skill training dummy").option("Pickpocket").results();

            if (results.isEmpty()) {
                ActionBar.useItem("Thieving skill training dummy", "Deploy");
                println("No available dummies. Attempting to deploy a new Thieving skill training dummy.");
                Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !NpcQuery.newQuery().name("Thieving skill training dummy").option("Pickpocket").results().isEmpty());
                results = NpcQuery.newQuery().name("Thieving skill training dummy").option("Pickpocket").results();
            }

            for (Npc dummy : results) {
                if (dummy.interact("Pickpocket")) {
                    println("Successfully interacted with Thieving skill training dummy.");
                    Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !dummy.validate());
                    break;
                } else {
                    println("Failed to interact with the Thieving skill training dummy.");
                }
            }

            if (results.isEmpty()) {
                println("The dummy is no longer available or could not be deployed.");
            }
        }
    }

    private void UseAgilityDummy() {
        EntityResultSet<Npc> results = NpcQuery.newQuery().name("Agility skill training dummy").option("Practice").results();

        if (results.isEmpty()) {
            ActionBar.useItem("Agility skill training dummy", "Deploy");
            println("No available dummies. Attempting to deploy a new Agility skill training dummy.");
            Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !NpcQuery.newQuery().name("Agility skill training dummy").option("Practice").results().isEmpty());
            results = NpcQuery.newQuery().name("Agility skill training dummy").option("Practice").results();
        }

        for (Npc dummy : results) {
            if (dummy.interact("Practice")) {
                println("Successfully interacted with Agility skill training dummy.");
                Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !dummy.validate());
                break;
            } else {
                println("Failed to interact with Agility skill training dummy.");
            }
        }

        if (results.isEmpty()) {
            println("The dummy is no longer available or could not be deployed.");
        }
    }

    private void UseMagicDummy() {
        EntityResultSet<Npc> results = NpcQuery.newQuery().name("Magic training dummy").option("Attack").results();

        if (results.isEmpty()) {
            ActionBar.useItem("Combat training dummy", "Deploy");
            println("No available dummies. Attempting to deploy a new Magic training dummy.");
            Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !NpcQuery.newQuery().name("Magic training dummy").option("Attack").results().isEmpty());
            results = NpcQuery.newQuery().name("Magic training dummy").option("Attack").results();
        }

        for (Npc dummy : results) {
            if (dummy.interact("Attack")) {
                println("Successfully initiated attack on the Magic training dummy.");
                Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !dummy.validate());
                break;
            } else {
                println("Failed to initiate attack on the Magic training dummy.");
            }
        }

        if (results.isEmpty()) {
            println("The dummy is no longer available or could not be deployed.");
        }
    }

    private void UseRangedDummy() {
        EntityResultSet<Npc> results = NpcQuery.newQuery().name("Ranged training dummy").option("Attack").results();

        if (results.isEmpty()) {
            ActionBar.useItem("Combat training dummy", "Deploy");
            println("No available dummies. Attempting to deploy a new Ranged training dummy.");
            Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !NpcQuery.newQuery().name("Ranged training dummy").option("Attack").results().isEmpty());
            results = NpcQuery.newQuery().name("Ranged training dummy").option("Attack").results();
        }

        for (Npc dummy : results) {
            if (dummy.interact("Attack")) {
                println("Successfully initiated attack on the Ranged training dummy.");
                Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !dummy.validate());
                break;
            } else {
                println("Failed to initiate attack on the Ranged training dummy.");
            }
        }

        if (results.isEmpty()) {
            println("The dummy is no longer available or could not be deployed.");
        }
    }

    private void UseMeleeDummy() {
        EntityResultSet<Npc> results = NpcQuery.newQuery().name("Melee training dummy").option("Attack").results();

        if (results.isEmpty()) {
            ActionBar.useItem("Combat training dummy", "Deploy");
            println("No available dummies. Attempting to deploy a new Melee training dummy.");
            Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !NpcQuery.newQuery().name("Melee training dummy").option("Attack").results().isEmpty());
            results = NpcQuery.newQuery().name("Melee training dummy").option("Attack").results();
        }

        for (Npc dummy : results) {
            if (dummy.interact("Attack")) {
                println("Successfully initiated attack on the Melee training dummy.");
                Execution.delayUntil(RandomGenerator.nextInt(20000, 30000), () -> !dummy.validate());
                break;
            } else {
                println("Failed to initiate attack on the Melee training dummy.");
            }
        }

        if (results.isEmpty()) {
            println("The dummy is no longer available or could not be deployed.");
        }
    }

    private void setupStartingSkillLevels() {
        startingAttackLevel = Skills.ATTACK.getSkill().getLevel();
        startingStrengthLevel = Skills.STRENGTH.getSkill().getLevel();
        startingDefenseLevel = Skills.DEFENSE.getSkill().getLevel();
        startingRangedLevel = Skills.RANGED.getSkill().getLevel();
        startingPrayerLevel = Skills.PRAYER.getSkill().getLevel();
        startingMagicLevel = Skills.MAGIC.getSkill().getLevel();
        startingRunecraftingLevel = Skills.RUNECRAFTING.getSkill().getLevel();
        startingConstructionLevel = Skills.CONSTRUCTION.getSkill().getLevel();
        startingDungeoneeringLevel = Skills.DUNGEONEERING.getSkill().getLevel();
        startingArchaeologyLevel = Skills.ARCHAEOLOGY.getSkill().getLevel();
        startingConstitutionLevel = Skills.CONSTITUTION.getSkill().getLevel();
        startingAgilityLevel = Skills.AGILITY.getSkill().getLevel();
        startingHerbloreLevel = Skills.HERBLORE.getSkill().getLevel();
        startingThievingLevel = Skills.THIEVING.getSkill().getLevel();
        startingCraftingLevel = Skills.CRAFTING.getSkill().getLevel();
        startingFletchingLevel = Skills.FLETCHING.getSkill().getLevel();
        startingSlayerLevel = Skills.SLAYER.getSkill().getLevel();
        startingHunterLevel = Skills.HUNTER.getSkill().getLevel();
        startingDivinationLevel = Skills.DIVINATION.getSkill().getLevel();
        startingNecromancyLevel = Skills.NECROMANCY.getSkill().getLevel();
        startingMiningLevel = Skills.MINING.getSkill().getLevel();
        startingSmithingLevel = Skills.SMITHING.getSkill().getLevel();
        startingFishingLevel = Skills.FISHING.getSkill().getLevel();
        startingCookingLevel = Skills.COOKING.getSkill().getLevel();
        startingFiremakingLevel = Skills.FIREMAKING.getSkill().getLevel();
        startingWoodcuttingLevel = Skills.WOODCUTTING.getSkill().getLevel();
        startingFarmingLevel = Skills.FARMING.getSkill().getLevel();
        startingSummoningLevel = Skills.SUMMONING.getSkill().getLevel();
        startingInventionLevel = Skills.INVENTION.getSkill().getLevel();
    }


    public void checkAndPerformLogout() {
        if (Logout) {
            if (System.currentTimeMillis() >= targetLogoutTimeMillis && targetLogoutTimeMillis != 0) {
                println("Logout time reached.");
                while (Client.getLocalPlayer() != null && Client.getLocalPlayer().inCombat()) {
                    println("Player is in combat, waiting until combat ends to logout.");
                    Execution.delay(1000);
                }
                println("Player is no longer in combat, attempting to logout.");
                if (performLogout()) {
                    println("Logout successful.");
                    targetLogoutTimeMillis = 0;
                } else {
                    println("Failed to logout.");
                }
            }
        }
    }

    public boolean performLogout() {
        MiniMenu.interact(ComponentAction.COMPONENT.getType(), 1, 7, 93782016);
        println("Opening Settings menu.");
        Execution.delay(RandomGenerator.nextInt(800, 1000));
        boolean logoutMenuOpened = Execution.delayUntil(1000L, () -> Interfaces.isOpen(1433));
        if (logoutMenuOpened) {
            Execution.delay(RandomGenerator.nextInt(1000, 2000));
            MiniMenu.interact(ComponentAction.COMPONENT.getType(), 1, -1, 93913159);
            println("Attempting to interact with logout button.");
            Execution.delay(RandomGenerator.nextInt(1000, 3000));
            this.stopScript();
            return true;
        } else {
            this.println("Could not find or interact with the logout button.");
            return false;
        }
    }

    public void setTargetLogoutTimeMillis(long targetLogoutTimeMillis) {
        this.targetLogoutTimeMillis = targetLogoutTimeMillis;
    }

    public long getTargetLogoutTimeMillis() {
        return this.targetLogoutTimeMillis;
    }

    private void KwuarmincenceSticks() {
        if (KwuarmIncence) {
            ResultSet<Item> backpackResults = InventoryItemQuery.newQuery(93)
                    .name("Kwuarm incence sticks")
                    .results();

            if (!backpackResults.isEmpty()) {
                ResultSet<Component> componentResults = ComponentQuery.newQuery(284)
                        .spriteId(47709)
                        .results();

                if (componentResults.isEmpty()) {
                    Item itemToInteract = backpackResults.first();

                    String option = "Light";
                    if (overloadEnabled) {
                        option = "Overload";
                    }

                    if (Backpack.interact(option)) {
                        println("Interaction successful with option: " + option);
                    } else {
                        println("Failed to interact with the item using option: " + option);
                    }
                }
            }
        }
    }

    private void LantadymeIncenseSticks() {
        if (LantadymeIncence) {
            ResultSet<Item> backpackResults = InventoryItemQuery.newQuery(93)
                    .name("Lantadyme incence sticks")
                    .results();

            if (!backpackResults.isEmpty()) {
                ResultSet<Component> componentResults = ComponentQuery.newQuery(284)
                        .spriteId(47713)
                        .results();

                if (componentResults.isEmpty()) {
                    Item itemToInteract = backpackResults.first();

                    String option = "Light";
                    if (overloadEnabled) {
                        option = "Overload";
                    }

                    if (Backpack.interact(option)) {
                        println("Interaction successful with option: " + option);
                    } else {
                        println("Failed to interact with the item using option: " + option);
                    }
                }
            }
        }
    }

    private void TorstolIncenseSticks() {
        if (TorstolIncence) {
            ResultSet<Item> backpackResults = InventoryItemQuery.newQuery(93)
                    .name("Torstol incence sticks")
                    .results();

            if (!backpackResults.isEmpty()) {
                ResultSet<Component> componentResults = ComponentQuery.newQuery(284)
                        .spriteId(47715)
                        .results();

                if (componentResults.isEmpty()) {
                    Item itemToInteract = backpackResults.first();

                    String option = "Light";
                    if (overloadEnabled) {
                        option = "Overload";
                    }

                    if (Backpack.interact(option)) {
                        println("Interaction successful with option: " + option);
                    } else {
                        println("Failed to interact with the item using option: " + option);
                    }
                }
            }
        }
    }

    private void Penance() {
        if (usePenance) {
            ResultSet<Item> results = InventoryItemQuery.newQuery(93).ids(52806).option("Scatter").results();
            boolean varbitNotSet = VarManager.getVarbitValue(50841) == 0;

            if (!results.isEmpty() && varbitNotSet) {
                Execution.delay(RandomGenerator.nextInt(1000, 2000));
                Item itemToInteract = results.first();
                if (itemToInteract != null) {
                    boolean interacted = Backpack.interact(itemToInteract.getName(), "Scatter");
                    if (interacted) {
                        println("Interacted with Powder of Penance.");
                    } else {
                        println("Failed to interact with Powder of Penance.");
                    }
                }
            }
        }
    }

    private void Protection() {
        if (useProtection) {
            ResultSet<Item> results = InventoryItemQuery.newQuery(93).ids(52802).option("Scatter").results();
            boolean varbitNotSet = VarManager.getVarbitValue(50837) == 0;

            if (!results.isEmpty() && varbitNotSet) {
                Execution.delay(RandomGenerator.nextInt(1000, 2000));
                Item itemToInteract = results.first();
                if (itemToInteract != null) {
                    boolean interacted = Backpack.interact(itemToInteract.getName(), "Scatter");
                    if (interacted) {
                        println("Interacted with Powder of Protection.");
                    } else {
                        println("Failed to interact with Powder of Protection.");
                    }
                }
            }
        }
    }

    private boolean isCrystalMaskActive() {
        ComponentQuery query = ComponentQuery.newQuery(284).spriteId(25938);
        ResultSet<Component> results = query.results();

        return !results.isEmpty();
    }


    private void CystalMask() {
        if (useCrystalMask && !isCrystalMaskActive()) {
            println("Activating Crystal Mask.");
            if (ActionBar.useAbility("Crystal Mask")) {
                println("Crystal Mask activated successfully.");
                Execution.delay(RandomGenerator.nextInt(1000, 2000));
            } else {
                println("Failed to activate Crystal Mask.");
            }
        }
    }

    private boolean lightFormActive = false;


    private void LightFormActivation() {
        if (useLightForm) {
            int lightFormEnabled = VarManager.getVarbitValue(29066);
            if (!lightFormActive && lightFormEnabled != 1) {
                activateLightForm();
            } else if (lightFormActive && lightFormEnabled == 1 && !useLightForm) {
                deactivateLightForm();
            }
        }
    }

    private void activateLightForm() {
        ActionBar.useAbility("Light Form");
        println("Light Form activated.");
        Execution.delay(RandomGenerator.nextInt(1000, 2000));
    }

    private void deactivateLightForm() {
        int lightFormEnabled = VarManager.getVarbitValue(29066);
        if (lightFormEnabled == 1) {
            ActionBar.useAbility("Light Form");
            println("Light Form deactivated.");
            Execution.delay(RandomGenerator.nextInt(1000, 2000));
        }
    }

    private boolean superheatFormActive = false;

    private void SuperheatFormActivation() {
        if (useSuperheatForm) {
            int superheatFormEnabled = VarManager.getVarbitValue(29071);
            if (!superheatFormActive && superheatFormEnabled != 1) {
                activateSuperheatForm();
            } else if (superheatFormActive && superheatFormEnabled == 1 && !useSuperheatForm) {
                deactivateSuperheatForm();
            }
        }
    }

    private void activateSuperheatForm() {
        ActionBar.useAbility("Superheat Form");
        println("Superheat Form activated.");
        Execution.delay(RandomGenerator.nextInt(1000, 2000));
        superheatFormActive = true; // Update the state to reflect activation
    }

    private void deactivateSuperheatForm() {
        int superheatFormEnabled = VarManager.getVarbitValue(29071);
        if (superheatFormEnabled == 1) {
            ActionBar.useAbility("Superheat Form");
            println("Superheat Form deactivated.");
            Execution.delay(RandomGenerator.nextInt(1000, 2000));
            superheatFormActive = false; // Update the state to reflect deactivation
        }
    }

    private boolean isNecromancyActive() {
        Component necromancy = ComponentQuery.newQuery(284) // Assuming this interface ID is correct; adjust if necessary
                .spriteId(30125) // Updated sprite ID for Necromancy
                .results().first();
        return necromancy != null;
    }

    private void NecromancyPotion() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (!isNecromancyActive()) {
                ResultSet<Item> results = InventoryItemQuery.newQuery(93)
                        .name("necromancy", String::contains)
                        .option("Drink")
                        .results();
                if (!results.isEmpty()) {
                    Item necromancyItem = results.first();
                    if (necromancyItem != null) {
                        boolean success = Backpack.interact(necromancyItem.getName(), "Drink");
                        if (success) {
                            println("Using necromancy item: " + necromancyItem.getName());
                        } else {
                            println("Failed to use necromancy item: " + necromancyItem.getName());
                        }
                        Execution.delay(RandomGenerator.nextInt(2000, 3000));
                    }
                } else {
                    println("No necromancy items found.");
                }
            } else {
                println("Necromancy boost is already active.");
            }
        }
    }

    private boolean isantifireActive() {
        Component necromancy = ComponentQuery.newQuery(284) // Assuming this interface ID is correct; adjust if necessary
                .spriteId(30093) // Updated sprite ID for Necromancy
                .results().first();
        return necromancy != null;
    }

    private void antifirePotion() {
        if (useAntifire) {
            Player localPlayer = Client.getLocalPlayer();
            if (localPlayer != null) {
                if (!isantifireActive()) {
                    ResultSet<Item> items = InventoryItemQuery.newQuery(93).results();
                    Item antifireItem = items.stream()
                            .filter(item -> item.getName() != null && item.getName().toLowerCase().contains("antifire"))
                            .findFirst()
                            .orElse(null);

                    if (antifireItem != null) {
                        Backpack.interact(antifireItem.getName(), "Drink");
                        println("Drinking " + antifireItem.getName());
                    } else {
                        println("No Antifire potions found!");
                    }
                } else {
                    println("Antifire boost is already active.");
                }
            }
        }
    }

    private boolean isExcaliburActive() {
        Component excaliburComponent = ComponentQuery.newQuery(291)
                .spriteId(14632)
                .results().first();
        return excaliburComponent != null;
    }

    private void activateExcalibur() {
        Player localPlayer = Client.getLocalPlayer();
        if (localPlayer != null) {
            if (localPlayer.getCurrentHealth() * 100 / localPlayer.getMaximumHealth() < healthThreshold) {
                if (!isExcaliburActive()) {
                    ResultSet<Item> items = InventoryItemQuery.newQuery(93).results();
                    Item excaliburItem = items.stream()
                            .filter(item -> item.getName() != null && item.getName().toLowerCase().contains("excalibur"))
                            .findFirst()
                            .orElse(null);

                    if (excaliburItem != null) {
                        Backpack.interact(excaliburItem.getName(), "Activate");
                        println("Activating " + excaliburItem.getName());
                    } else {
                        println("No Excalibur found!");
                    }
                } else {
                    println("Excalibur is on CD.");
                }
            } else {
                println("Health is above threshold, no need to activate Excalibur.");
            }
        }
    }

    private boolean scriptureOfWenActive = false;

    public void manageScriptureOfWen() {
        if (LOCAL_PLAYER.inCombat() && !scriptureOfWenActive) {
            updateScriptureOfWenActivation();
        } else if (!LOCAL_PLAYER.inCombat() && scriptureOfWenActive) {
            updateScriptureOfWenActivation();
        }
    }

    private void updateScriptureOfWenActivation() {
        // Querying the component to check if Scripture of Wen is active
        boolean isActive = isScriptureOfWenActive();

        boolean shouldBeActive = shouldActivateScriptureOfWen();

        if (shouldBeActive && !isActive) {
            activateScriptureOfWen();
        } else if (!shouldBeActive && isActive) {
            deactivateScriptureOfWen();
        }
    }

    private boolean isScriptureOfWenActive() {
        // Using component query to check if Scripture of Wen is active
        ComponentQuery query = ComponentQuery.newQuery(284).spriteId(52117);
        ResultSet<Component> results = query.results();
        // If the component with the specific sprite id exists, then Scripture of Wen is considered active
        return !results.isEmpty();
    }

    private void activateScriptureOfWen() {
        if (!scriptureOfWenActive) {
            println("Activating Scripture of Wen.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Activate/Deactivate")) {
                println("Scripture of Wen activated successfully.");
                scriptureOfWenActive = true;
            } else {
                println("Failed to activate Scripture of Wen.");
            }
        }
    }

    private void deactivateScriptureOfWen() {
        if (scriptureOfWenActive) {
            println("Deactivating Scripture of Wen.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Activate/Deactivate")) {
                println("Scripture of Wen deactivated.");
                scriptureOfWenActive = false;
            } else {
                println("Failed to deactivate Scripture of Wen.");
            }
        }
    }

    private boolean shouldActivateScriptureOfWen() {
        return LOCAL_PLAYER.inCombat() && (UseScriptureOfWen); // Assuming UseScriptureOfWen is a condition you define
    }

    private boolean scriptureOfJasActive = false;

    public void manageScriptureOfJas() {
        if (LOCAL_PLAYER.inCombat() && !scriptureOfJasActive) {
            updateScriptureOfJasActivation();
        } else if (!LOCAL_PLAYER.inCombat() && scriptureOfJasActive) {
            updateScriptureOfJasActivation();
        }
    }

    private void updateScriptureOfJasActivation() {
        // Querying the component to check if Scripture of Jas is active
        boolean isActive = isScriptureOfJasActive();

        boolean shouldBeActive = shouldActivateScriptureOfJas();

        if (shouldBeActive && !isActive) {
            activateScriptureOfJas();
        } else if (!shouldBeActive && isActive) {
            deactivateScriptureOfJas();
        }
    }

    private boolean isScriptureOfJasActive() {
        // Using component query to check if Scripture of Jas is active
        ComponentQuery query = ComponentQuery.newQuery(284).spriteId(51814);
        ResultSet<Component> results = query.results();
        // If the component with the specific sprite id exists, then Scripture of Jas is considered active
        return !results.isEmpty();
    }

    private void activateScriptureOfJas() {
        if (!scriptureOfJasActive) {
            println("Activating Scripture of Jas.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Activate")) {
                println("Scripture of Jas activated successfully.");
                scriptureOfJasActive = true;
            } else {
                println("Failed to activate Scripture of Jas.");
            }
        }
    }

    private void deactivateScriptureOfJas() {
        if (scriptureOfJasActive) {
            println("Deactivating Scripture of Jas.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Deactivate")) {
                println("Scripture of Jas deactivated.");
                scriptureOfJasActive = false;
            } else {
                println("Failed to deactivate Scripture of Jas.");
            }
        }
    }

    private boolean shouldActivateScriptureOfJas() {
        return LOCAL_PLAYER.inCombat() && (UseScriptureOfJas); // Assuming UseScriptureOfJas is a condition you define
    }

    private boolean scriptureOfFulActive = false;

    public void manageScriptureOfFul() {
        if (LOCAL_PLAYER.inCombat() && !scriptureOfFulActive) {
            updateScriptureOfFulActivation();
        } else if (!LOCAL_PLAYER.inCombat() && scriptureOfFulActive) {
            updateScriptureOfFulActivation();
        }
    }

    private void updateScriptureOfFulActivation() {
        // Querying the component to check if Scripture of Ful is active
        boolean isActive = isScriptureOfFulActive();

        boolean shouldBeActive = shouldActivateScriptureOfFul();

        if (shouldBeActive && !isActive) {
            activateScriptureOfFul();
        } else if (!shouldBeActive && isActive) {
            deactivateScriptureOfFul();
        }
    }

    private boolean isScriptureOfFulActive() {
        // Using component query to check if Scripture of Ful is active
        ComponentQuery query = ComponentQuery.newQuery(284).spriteId(52494);
        ResultSet<Component> results = query.results();
        // If the component with the specific sprite id exists, then Scripture of Ful is considered active
        return !results.isEmpty();
    }

    private void activateScriptureOfFul() {
        if (!scriptureOfFulActive) {
            println("Activating Scripture of Ful.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Activate")) {
                println("Scripture of Ful activated successfully.");
                scriptureOfFulActive = true;
            } else {
                println("Failed to activate Scripture of Ful.");
            }
        }
    }

    private void deactivateScriptureOfFul() {
        if (scriptureOfFulActive) {
            println("Deactivating Scripture of Ful.");
            if (Equipment.interact(Equipment.Slot.POCKET, "Deactivate")) {
                println("Scripture of Ful deactivated.");
                scriptureOfFulActive = false;
            } else {
                println("Failed to deactivate Scripture of Ful.");
            }
        }
    }

    private boolean shouldActivateScriptureOfFul() {
        return LOCAL_PLAYER.inCombat() && (UseScriptureOfFul); // Assuming UseScriptureOfFul is a condition you define
    }

    private void DeathGrasp() {
        // Check if the 'UseDeathGrasp' condition is met (this variable's declaration and assignment are not shown)
        if (UseDeathGrasp) {
            // Ensure the local player exists and is in combat
            if (getLocalPlayer() != null && getLocalPlayer().inCombat()) {
                // Ensure the local player has a target
                if (getLocalPlayer().getTarget() != null) {
                    // Check if the local player's adrenaline is over 25%
                    if (getLocalPlayer().getAdrenaline() > 25) {
                        // Query for a component with a specific sprite ID on interface 291
                        // Note: This assumes a method `getAdrenaline()` exists that returns adrenaline as a percentage
                        if (ComponentQuery.newQuery(291).spriteId(55524).results().isEmpty()) {
                            // Use the ability 'Death's Grasp' if the sprite is not active
                            boolean abilityUsed = ActionBar.useAbility("Death Grasp");
                            if (abilityUsed) {
                                println("Used 'Death's Grasp' on " + getLocalPlayer().getTarget().getName());
                            } else {
                                println("Failed to use 'Death's Grasp'");
                            }
                        } else {
                            println(getLocalPlayer().getTarget().getName() + " already has the debuff.");
                        }
                    } else {
                        println("Insufficient adrenaline for 'Death's Grasp'.");
                    }
                } else {
                    println("No target NPC found.");
                }
            }
        }
    }
}





