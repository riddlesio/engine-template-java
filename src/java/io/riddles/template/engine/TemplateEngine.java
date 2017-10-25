/*
 *  Copyright 2017 riddles.io (developers@riddles.io)
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 *      For the full copyright and license information, please view the LICENSE
 *      file that was distributed with this source code.
 */

package io.riddles.template.engine;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import io.riddles.javainterface.configuration.Configuration;
import io.riddles.javainterface.engine.AbstractEngine;
import io.riddles.javainterface.engine.GameLoopInterface;
import io.riddles.javainterface.engine.SimpleGameLoop;
import io.riddles.javainterface.exception.TerminalException;
import io.riddles.javainterface.game.player.PlayerProvider;
import io.riddles.javainterface.io.IOInterface;
import io.riddles.template.game.TemplateSerializer;
import io.riddles.template.game.player.TemplatePlayer;
import io.riddles.template.game.processor.TemplateProcessor;
import io.riddles.template.game.state.TemplateState;

/**
 * io.riddles.template.engine.TemplateEngine - Created on 25-10-17
 *
 * The Backbone of the application. Creates everything needed to run, like the processor,
 * the players and the initial state.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateEngine extends AbstractEngine<TemplateProcessor, TemplatePlayer, TemplateState> {

    public static SecureRandom RANDOM;  // If random is needed

    public TemplateEngine(PlayerProvider<TemplatePlayer> playerProvider, IOInterface ioHandler) throws TerminalException {
        super(playerProvider, ioHandler);
    }

    /**
     * Create the configuration object and initializes it with the default values
     * These values will be overwritten by the values in the wrapper-commands.json
     * if they are present there.
     * @return The configuration object.
     */
    @Override
    protected Configuration getDefaultConfiguration() {
        Configuration configuration = new Configuration();

        // These are common configuration examples
        configuration.put("maxRounds", 100);
        configuration.put("seed", UUID.randomUUID().toString());

        return configuration;
    }

    /**
     * Creates the processor. Doesn't need to be edited.
     * @return The processor.
     */
    @Override
    protected TemplateProcessor createProcessor() {
        return new TemplateProcessor(this.playerProvider);
    }

    /**
     * Creates the game loop. Doesn't need to be edited.
     * @return The game loop.
     */
    @Override
    protected GameLoopInterface createGameLoop() {
        return new SimpleGameLoop();
    }

    /**
     * Creates a player with given ID.
     * @param id The player ID.
     * @return The player.
     */
    @Override
    protected TemplatePlayer createPlayer(int id) {
        return new TemplatePlayer(id);
    }

    /**
     * Sends the game settings to to player. Timebank settings, etc. are sent
     * by the gamewrapper, so don't need to be included here.
     * @param player Player to send the settings to.
     */
    @Override
    protected void sendSettingsToPlayer(TemplatePlayer player) {
        // Examples:
        // player.sendSetting("your_botid", player.getId());
        // player.sendSetting("max_rounds", configuration.getInt("maxRounds"));
    }

    /**
     * Creates the initial state of the game.
     * @return The initial state of the game.
     */
    @Override
    protected TemplateState getInitialState() {
        setRandomSeed();

        // Create the initial state with the initial player states here

        return null;
    }

    /**
     * Creates and returns the game file for the frontend matchviewer. Doesn't need
     * to be edited. (Edit the serializers instead.)
     * @param initialState The first state of the game.
     * @return The string representation of the game file for the frontend.
     */
    @Override
    protected String getPlayedGame(TemplateState initialState) {
        TemplateSerializer serializer = new TemplateSerializer();
        return serializer.traverseToString(this.processor, initialState);
    }

    /**
     * Initializes the SecureRandom with the seed from configuration.
     */
    protected void setRandomSeed() {
        try {
            RANDOM = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.severe("Not able to use SHA1PRNG, using default algorithm");
            RANDOM = new SecureRandom();
        }
        String seed = configuration.getString("seed");
        LOGGER.info("RANDOM SEED IS: " + seed);
        RANDOM.setSeed(seed.getBytes());
    }
}
