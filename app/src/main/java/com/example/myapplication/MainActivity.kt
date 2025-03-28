package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaring the variables used for the layout and game state
    private lateinit var mainLayout: LinearLayout // Main layout that changes background color
    private var isGameActive = false // Boolean to track if the game is active or not
    private lateinit var startGameButton: Button // Button to start the game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Setting the content view to activity_main layout

var statusIntit="not ACTIVE"


        // Finding the views by their IDs
        val statusText = findViewById<TextView>(R.id.statusText) // TextView to display game status
        val btnUp = findViewById<Button>(R.id.btnUp) // Button for "Up" action
        val btnDown = findViewById<Button>(R.id.btnDown) // Button for "Down" action
        val btnLeft = findViewById<Button>(R.id.btnLeft) // Button for "Left" action
        val btnRight = findViewById<Button>(R.id.btnRight) // Button for "Right" action
        startGameButton = findViewById(R.id.startGameButton) // Button to start the game

        // Initializing the main layout where background color will change
        mainLayout = findViewById(R.id.main)

        // Setting initial status text to inform the user that the game is not active
        statusText.text = statusIntit

        // Set an OnClickListener for the Start Game button
        // When clicked, it will activate the game and disable the button to prevent restarting
        startGameButton.setOnClickListener {
            isGameActive = true // Set the game to active
            statusText.text = getString(R.string.game_started) // Change the status text to indicate the game has started
            startGameButton.isEnabled = false // Disable the start button so it can't be clicked again
        }

        // Setting the onClickListeners for the directional buttons
        btnUp.setOnClickListener { handleAction("Up", statusText) }
        btnDown.setOnClickListener { handleAction("Down", statusText) }
        btnLeft.setOnClickListener { handleAction("Left", statusText) }
        btnRight.setOnClickListener { handleAction("Right", statusText) }
    }

    // Function to handle button clicks for the directional actions
    private fun handleAction(direction: String, statusText: TextView) {
        // Check if the game is active before allowing actions
        if (isGameActive) {
            when (direction) {
                "Up" -> {
                    statusText.text = getString(R.string.move_up) // Update status text to show direction
                    changeBackgroundColor(Color.BLUE) // Change background color to blue for Up action
                }
                "Down" -> {
                    statusText.text = getString(R.string.move_down) // Update status text for Down action
                    changeBackgroundColor(Color.RED) // Change background color to red for Down action
                }
                "Left" -> {
                    statusText.text = getString(R.string.move_left) // Update status text for Left action
                    changeBackgroundColor(Color.GREEN) // Change background color to green for Left action
                }
                "Right" -> {
                    statusText.text = getString(R.string.move_right) // Update status text for Right action
                    changeBackgroundColor(Color.YELLOW) // Change background color to yellow for Right action
                }
                else -> statusText.text = getString(R.string.invalid_move) // If direction is invalid, show an error message
            }
        } else {
            // If the game is not active, inform the user
            statusText.text = getString(R.string.game_not_active)
        }
    }

    // Function to change the background color of the main layout
    private fun changeBackgroundColor(color: Int) {
        mainLayout.setBackgroundColor(color) // Set the background color of the main layout
    }
}
