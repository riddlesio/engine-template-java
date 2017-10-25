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

package io.riddles.template.game.player;

import io.riddles.javainterface.game.player.AbstractPlayer;

/**
 * io.riddles.template.game.player.TemplatePlayer - Created on 25-10-17
 *
 * This class is used to send stuff to the bot. Most likely doesn't really need
 * to be changed at all because AbstractPlayer implements everything mostly. Any data about
 * the player should be stored in a playerState.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplatePlayer extends AbstractPlayer {

    public TemplatePlayer(int id) {
        super(id);
    }
}
