<p align="center">
  <img src="/misc/shyhi_logo.png"/>
</p>

Location based anonymous messaging application. It's like heroin for your connectivity fix. Get frisky.
###How To Install
================
If you haven't already:
* Install Eclipse
* Download and install the [Android SDK and Eclipse ADT](https://developer.android.com/sdk/index.html?hl=i#download)
* Set up Git

Cloning from the github repo:
* Find a location on your machine where you would like to house the project
* git clone https://github.com/ShyHi/ShyHi_Android.git --depth 1
* note that the --depth 1 option allows for faster cloning

Importing the Project into Eclipse
  * File -> Import
  * Choose Android > Existing Android Code into Workspace 
  * Locate the cloned repo on your machine and select it
  * Select both dev/ShyHi and dev/appcompat_v7
  * Rename dev/ShyHi from HomeScreen to ShyHi, or whatever is desired
  * Import

Running the application:<br>
Via Eclipse:<br>
  * With an Android device connected via USB Debugging and ADB or an Android Emulator set up, right click the project->run as android application <br>
Via APK <br>
  * Download and install the provided APK.


![alt tag](https://raw.github.com/rugggg/ShyHi/master/misc/shyHi1.png)
![alt tag](https://raw.github.com/rugggg/ShyHi/master/misc/shyHi2.png)
![alt tag](https://raw.githubusercontent.com/rugggg/ShyHi/master/misc/shyHi3.png)

[What is Shyhi?](http://youtu.be/poksBjqQLPg)

Checkout the [awesome landing page](http://chapmancpsc370.github.io/ShyHi/)

###Mission Statement: 
=====
Our Mission, honestly, we're just looking to fight boredom, have a good laugh. We're not trying to change the world or go full Zuckerberg. We're not going to steal your data, sell it, or leak your illicit goodies. So if you're a connection junkie like ourselves and most millenials, check out what we've done and contribute in any way you can!

###How It Works
============ 

There's nothing special about what ShyHi is or does. Open up the app and it will figure out where you are, 
other users around you and set you up to start chatting with another strange soul lost in our trippy world.

Seriously, that's it. You don't need a profile pic, song, or custom layout. You don't have to login to the
43321st app using facebook or google+ profile. No one needs to or will know who you are(we promise nothing
about keeping the strange creatures from outside out solar system or the really smart people in the government 
out of your business though). Just open it up, type something stupid and hopefuly you won't die of boredom.

###Get Involved, get Support

Check out our forum to communicate with other contributors and to find support: <a href="http://shihi.yuku.com">ShyHi Forums</a>


###Features
========
* Location based, only chat with those around you, easier to discuss the weather this way
* Anonymous, because we're all to shy to talk to a stranger face to face
* No log ins, accounts, nothing


###Development Status
==================

We can always use more help, it's tough to be frisky by ourselves, check out our getting started and developer docs to jump in.

Current: Minimum Viable Product in progress
#### MVP 
* Android Application
* Determines and matches users based upon location
* Functional messaging



Future: In the future we hope to add an iOS app that functions the same way. We also hope to add 
many new features: group Hi's (chatrooms), themed conversations, and potentially video 
functionality. If you want to help us get these going please jump right in, see our Getting Started guide for help.


View Business Model Canvas: **working on new iteration, link will be here shortly

####Application Development Status and Goals:

Last Achieved Goal: Messages Post to CouchDB Server

Next Goals: Unique User IDs
            New Conversation Functionaloty
            Location Services


###Application Infrastructure & Design
===================================

ShyHi trys to keep it simple. We're leveraging other open source software to power this little project of ours. We're running an Ubunutu 14.04 server hosted on DigitalOcean paid for by the github student pack. CouchDb is powering our server database and RESTful services. We think its a pretty neat bit of
open source software and find that it meets all of our needs. Google Play Services are powering  our location services and we've taken inspiration and tips from a number of other open source projects.

###Contributors
============
Jared Stephens

Doug Woodward

