# baguette-boy
Prototype of the game built for APCS

Authors: Eric Cheng and David McAllister
________________________________________________________________
UNTITLED by Eric Cheng, David McAllister

	UNTITLED by Eric Cheng and David McAllister strives to eliminate the everyday struggle plaguing the human population: boredom.  By creating the most incomprehensibly stellar video game ever conceived, boredom shall be eliminated.
	UNTITLED will follow generally agreed upon videogame principles so that anyone with game literacy will be able to pick up and play.  All action will take place from a side-scrolling perspective, so the game mechanics will follow common conventions for that genre.  
The character will traverse in an environment with landscape features such as platforms and walls.  A 2D physics system will govern movement in this environment and a tight, responsive control scheme will make such movement enjoyable.  Littered around the environment will be enemies with which the character interacts.  These will test the mechanics the player learns through interacting with the environment while making them problem solve while playing.  The enemies will increase in difficulty leading up to a boss that provides the biggest challenge to the player.  
Ultimately, this game would be accessible to all players, while providing enough difficulty to video game enthusiasts.  This would keep the game open and intriguing to a large variety of people.

Instructions:
WASD movement control scheme
Mouse to control aim on ranged items
Spacebar to attack

FEATURES LIST:
Must-haves:
(Done)2D physics - A smooth and functional physics engine that allows for natural jumping, movement, and collisions
(Done)Enemies - Enemies with health for the player to deal with in order to add difficulty
(In-Progress)Player combat - a weapon and health for the player
(Done)Side-scrolling - Screen that only shows a portion of the entire map

Want-to-haves:
Inventory system - A scroll wheel based inventory system to store items
Different weapons - Different weapons (slower heavy hitting, multi-shot, etc.) would make gameplay more unique
Single use items - Things like health potions or damage increase to give the player more options when fighting
Boss fights - A boss with lots of health and multiple attack patterns
Pause menu - a pause menu overlay for the player to temporarily stop the game
Visual improvements - Features to make the game more aesthetically pleasing
Damage indicators - Numbers to show how much damage the player has dealt
Player/enemy animations - Animations to make the scene seem more alive and interesting

Stretch Features
(In-Progress)Puzzles - Non-combat focused portions to allow for different gameplay
Multiple levels - Differently designed stages to allow for longer playthroughs
Dialogue/Cutscenes - Bosses and NPCs would speak to create a more immersive gameplay environment
Story - A story told through dialogue and cutscenes to explain the background behind the player’s adventure
Animated background - A background with parallax scrolling and other items to make a more aesthetically pleasing environment
Item Descriptions - ability to check items for their various attributes

CLASS LIST:
Main - starts program
DrawingSurface - Draws everything
Manager - Holds and controls all the objects
GravitisedObject - Superclass for objects affected by gravity and collisions
Platform - static platforms for things to collide into
Player - represents the player and the actions the player does
DestroyListener(I) - Implemented by Manager and used by objects that need to destroy themselves/other objects
Health(I) - Implemented by classes with health

RESPONSIBILITIES:
Eric: Player abilities and (hopefully) inventory system. Enemy design.
David: Environment attributes. Physics and collision systems.
