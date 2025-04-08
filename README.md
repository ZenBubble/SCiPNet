# SCiPNet (SkipNet)
Open source android app for viewing SCP entries. Name is based off of [SCP-2317](https://scp-wiki.wikidot.com/scp-2317) by DrClef, which is the foundations in-universe main internet and database housing all of the SCP entries.

## Features 
### ❤️ = Not yet implemented 
### 💛 = Actively being developed 
### 💚 = Implemented
- ❤️ Android application on the Google play store written in Kotlin.
- ❤️ Persistant data such as bookmarked and history
- ❤️ Ability to view SCP entries on the main wiki through internet webscraping.
- ❤️ Options for secondary materials such as tales or sister sites such as the Wanderers Library.
- ❤️ A variety of reading options for accessibility and comfort, such as variable font size, font families, dark mode, etc.
- ❤️ Download articles and other pages to local storage for offline reading, with options for images or straight plaintext.
- ❤️ Chat with SCP-079?!?! (its 2025 of course im gonna have a chat bot)

## Legal Jargon
Content relating to the SCP Foundation, including the SCP Foundation logo, is licensed under Creative Commons Sharealike 3.0 and all concepts originate from https://scpwiki.com/ and its authors. This codebase and its assets, being derived from this content, is hereby also released under Creative Commons Sharealike 3.0.

## But how do dar work?
We use the wonderfully made SCP Data API made by tedivm, which can be found here https://scp-data.tedivm.com/. We use this API for quick navigation, but when on an individual SCP page, SCiPNet uses the SkrapeIt library for advanced css shenanigans, just how the creator wants it to be viewed.