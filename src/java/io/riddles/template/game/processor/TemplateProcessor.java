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

package io.riddles.template.game.processor;

import io.riddles.template.game.move.TemplateMoveDeserializer;
import io.riddles.javainterface.game.player.PlayerProvider;
import io.riddles.javainterface.game.processor.SimpleProcessor;
import io.riddles.template.game.player.TemplatePlayer;
import io.riddles.template.game.state.TemplateState;

/**
 * io.riddles.template.game.processor.TemplateProcessor - Created on 25-10-17
 *
 * If the Engine is the backbone, this class are the legs of the application. This class
 * is the thing that actually plays the game and creates the game states.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateProcessor extends SimpleProcessor<TemplateState, TemplatePlayer> {

    private TemplateMoveDeserializer moveDeseriazlier;

    /**
     * Creates the processor. Most likely doesn't need to be changed.
     * @param playerProvider The playerProvider that can be used to get the Player objects.
     */
    public TemplateProcessor(PlayerProvider<TemplatePlayer> playerProvider) {
        super(playerProvider);
        this.moveDeseriazlier = new TemplateMoveDeserializer();
    }

    /**
     * Use the given state to determine if the game has ended or not.
     * @param state Current game state.
     * @return True if the game has ended, false otherwise.
     */
    @Override
    public boolean hasGameEnded(TemplateState state) {
        return false;
    }

    /**
     * Use the given state to get the ID of the game winner.
     * @param state Current game state.
     * @return The ID number of the game winner, null if the game is a draw.
     */
    @Override
    public Integer getWinnerId(TemplateState state) {
        return null;
    }

    /**
     * Get the game score from the given state.
     * @param state The current game state.
     * @return The game score, mostly the amount of rounds.
     */
    @Override
    public double getScore(TemplateState state) {
        return state.getRoundNumber();  // For most games this is fine.
    }

    /**
     * The most important method of this class. Gets a state that is the end state of the
     * previous round. This method should clone that state and create all the intermediate
     * states needed until the end state of the new round is reached. Everything like
     * sending the game updates to the bot and asking for moves is done here.
     * @param inputState The last state of the previous round.
     * @param roundNumber The new round number.
     * @return The last state of the new round.
     */
    @Override
    public TemplateState createNextState(TemplateState inputState, int roundNumber) {
        TemplateState nextState = inputState.createNextState(roundNumber);

        // Update the state with the game logic, like asking the bots for the move

        // If the viewer needs multiple steps in a round, just create multiple states
        // here and return the last one.

        return nextState;
    }
}
