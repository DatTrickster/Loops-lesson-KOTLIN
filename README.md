# 🎮 **Game Control App (Android)**

Welcome to the **Game Control App**! 🎉 This app provides a simple way to control a virtual character's movement using directional buttons. Built with **Kotlin** for **Android**, it allows you to toggle the game state and change the screen background color based on your actions. Let’s dive in! 🚀

---

## 🛠️ **How It Works**

### 1. **UI Layout (activity_main.xml)**
The user interface is constructed using a `LinearLayout`, which organizes the UI elements in a vertical layout. It consists of:
- **TextView**: Displays the current game status (whether the game is active or not).
- **Buttons**: Represent the directional controls (Up, Down, Left, Right).
- **Start Game Button**: Activates the game and disables itself once the game begins.
- The **background color** of the screen changes based on the direction chosen. 🔵🟢🟡🔴

### 2. **Game Logic**

When the app starts:
- **TextView** starts with "Game Not Active" (it tells the user if the game is running).
- The **Start Game Button** toggles the game state.
    - When clicked, the game is activated, and the status text changes to "Game Started". The button is then disabled to prevent further clicks.
- Directional buttons (Up, Down, Left, Right) change the background color to represent different actions:
    - **Up**: Background turns **Blue** 🔵
    - **Down**: Background turns **Red** 🔴
    - **Left**: Background turns **Green** 🟢
    - **Right**: Background turns **Yellow** 🟡
- If the game isn’t active, clicking any directional button will show a message saying "Game Not Active".

---
## 🔄 **Code if else when **
```kotlin
if (isGameActive) {
    // If the game is active, execute the following block based on the direction
    when (direction) {
        "Up" -> {
            // Move up action
            statusText.text = getString(R.string.move_up)
            changeBackgroundColor(Color.BLUE)  // Set the background to Blue
        }
        "Down" -> {
            // Move down action
            statusText.text = getString(R.string.move_down)
            changeBackgroundColor(Color.RED)  // Set the background to Red
        }
        "Left" -> {
            // Move left action
            statusText.text = getString(R.string.move_left)
            changeBackgroundColor(Color.GREEN)  // Set the background to Green
        }
        "Right" -> {
            // Move right action
            statusText.text = getString(R.string.move_right)
            changeBackgroundColor(Color.YELLOW)  // Set the background to Yellow
        }
        else -> statusText.text = getString(R.string.invalid_move)  // If the direction is invalid
    }
} else {
    // If the game is not active, display "Game Not Active"
    statusText.text = getString(R.string.game_not_active)
}
