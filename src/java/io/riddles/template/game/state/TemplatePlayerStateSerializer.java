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

package io.riddles.template.game.state;

import org.json.JSONObject;

import io.riddles.javainterface.serialize.Serializer;

/**
 * io.riddles.template.game.state.TemplatePlayerStateSerializer - Created on 25-10-17
 *
 * [description]
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplatePlayerStateSerializer implements Serializer<TemplatePlayerState> {

    /**
     * Gets the string representation of the given playerState. Doesn't need to be edited.
     * @param playerState PlayerState.
     * @return String representation of the playerState.
     */
    @Override
    public String traverseToString(TemplatePlayerState playerState) {
        return visitState(playerState).toString();
    }

    /**
     * Gets the JSONObject representation of the given playerState.  Doesn't need to be edited.
     * @param playerState PlayerState.
     * @return JSONObject representation of the playerState.
     */
    @Override
    public JSONObject traverseToJson(TemplatePlayerState playerState) {
        return visitState(playerState);
    }

    /**
     * Edit this to create turn the playerState into the JSON representation needed for
     * the matchviewer.
     * @param playerState PlayerState.
     * @return JSON representation of the playerState.
     */
    private JSONObject visitState(TemplatePlayerState playerState) {
        JSONObject playerStateObj = new JSONObject();

        return playerStateObj;
    }
}
