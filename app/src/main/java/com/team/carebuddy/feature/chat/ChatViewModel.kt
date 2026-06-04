package com.team.carebuddy.feature.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team.carebuddy.feature.chat.model.ChatMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatMessage>>(
        listOf(ChatMessage("Hello! I'm your CareBuddy assistant. How can I help you today?", false))
    )
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    fun sendMessage(text: String) {
        if (text.isBlank()) return

        val userMessage = ChatMessage(text, true)
        _messages.value = _messages.value + userMessage

        viewModelScope.launch {
            delay(1000) // Simulate bot thinking
            val botResponse = getBotResponse(text)
            _messages.value = _messages.value + ChatMessage(botResponse, false)
        }
    }

    private fun getBotResponse(userText: String): String {
        val input = userText.lowercase()
        return when {
            input.contains("hello") || input.contains("hi") -> "Hi there! Remember to take your medications on time."
            input.contains("medication") || input.contains("medicine") -> "I can help you track your medications. You can add them using the '+' button on the home screen."
            input.contains("reminder") -> "Reminders are sent automatically based on the schedule you set for each medication."
            input.contains("how are you") -> "I'm doing great, helping users stay healthy! How can I assist you?"
            else -> "I'm still learning. For now, I can help with basic questions about medications and reminders."
        }
    }
}
