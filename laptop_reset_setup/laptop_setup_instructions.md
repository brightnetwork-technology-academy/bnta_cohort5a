# Laptop Setup Instructions

These instructions will help you set up your MacBook with the tools you will need throughout the course. This is not an exhaustive list, if there are other useful tools you want to install then feel free to do so. If you have any problems contact one of the trainers who can help you resolve it.

If you're new to using a mac [this video](https://www.youtube.com/watch?v=67keaaWOKzE) will give you an overview of the basics.

## Initial Setup

The previous user should have fully reset your MacBook and re-installed MacOS. When you switch it on you should be at the point where you need to create your account. **It is not necessary to create an Apple ID** - none of the software we will install will require one.

## Installing Command Line Tools

Open a terminal window using Spotlight. Press `command` + `space` to open the search bar and type "Terminal", then press the return key. 

> Spotlight will be a very useful tool for you going forward, it's worth practicing with.

For each of these tools copy/paste the text here into your terminal then press return. If any command throws an error saying you don't have permission, add "sudo " to the front of it and try again (eg. `sudo brew install git`). This will prompt you for your password any will override any access issues.

### Xcode Command Line Tools

Some of these tools may prompt you to install the *Xcode Command Line Tools*. We won't be using these directly, but they provide some services which are needed for other applications. If you are prompted to install Xcode you can do so using the command:

```sh
xcode-select –install
```

### Command Line Tools

- **[Oh-My-Zsh](https://ohmyz.sh/)** for a nicer terminal experience

```sh
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

- **[Homebrew](https://brew.sh/)** to make installing/managing packages easier

```sh
# step 1 - download
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# step 2 - installation
echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> /Users/$(whoami)/.zprofile   

eval "$(/opt/homebrew/bin/brew shellenv)"
```

- **[Git](https://formulae.brew.sh/formula/git#default)** for version control. 

```sh
# step 1 - installation
brew install git

# step 2 - configuring default branch
git config --global init.defaultBranch main
``` 

- **[Node](https://formulae.brew.sh/formula/node#default)** for running JavaScript code (includes npm)

```sh
brew install node
```

## Installing Apps

Follow the links to download each program.

- **[VSCode](https://code.visualstudio.com/)** for code editing, plus any extensions you want to add.
- **[IntelliJ](https://www.jetbrains.com/idea/download/#section=mac)** for Java editing. Make sure you select Community Edition (unless you want to pay for it) and the Apple Silicon version from the dropdown.
- **[Java](https://www.oracle.com/java/technologies/downloads/#java17)**. Make sure you are downloading Java 17, have selected the MacOS tab and use the `Arm 64DMG Installer`. Make sure you click on the downloaded installer so that Java 17 is installed as expected in your machine.
- **[Postgres.app](https://postgresapp.com/)** to get the PostgreSQL database tools.
- **[Postman](https://www.postman.com/)** for querying APIs. You'll need to create an account, but it's free.
- **[Chrome](https://www.google.co.uk/chrome)** for internet access. You'll also need the [React developer tools](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?hl=en) extension.
- **[Zoom](https://zoom.us/download)** so you can see the lessons.

