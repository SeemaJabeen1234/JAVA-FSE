// main.js

// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.onload = () => {
  alert("Page fully loaded!");
  fetchEvents();
};

// 2. Syntax, Data Types, and Operators
const eventName = "Music Fest";
const eventDate = "2025-06-10";
let availableSeats = 50;
console.log(`${eventName} on ${eventDate} has ${availableSeats} seats`);

function register() {
  if (availableSeats > 0) {
    availableSeats--;
    console.log(`Seat booked! ${availableSeats} remaining.`);
  }
}

// 3. Conditionals, Loops, and Error Handling
let events = [
  { name: "Yoga Class", date: "2025-06-01", seats: 10, category: "Health", location: "Community Center" },
  { name: "Old Event", date: "2024-12-01", seats: 5, category: "History", location: "Library" },
  { name: "Cooking Workshop", date: "2025-07-15", seats: 0, category: "Culinary", location: "Kitchen Studio" },
];

const today = new Date("2025-05-26");

events.forEach(event => {
  const eventDate = new Date(event.date);
  if (eventDate > today && event.seats > 0) {
    console.log(`${event.name} - Available`);
  }
});

function tryRegister(event) {
  try {
    if (event.seats <= 0) throw new Error("No seats left");
    event.seats--;
    console.log("Registered successfully");
  } catch (err) {
    console.error("Registration error:", err.message);
  }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, category, seats, location) {
  events.push({ name, date, category, seats, location });
}

function registerUser(event) {
  tryRegister(event);
}

function filterEventsByCategory(category, callback) {
  const result = events.filter(e => e.category === category);
  callback(result);
}

// Closure to track registration count by category
function createCategoryTracker(category) {
  let count = 0;
  return function () {
    count++;
    console.log(`Total registered in ${category}: ${count}`);
  };
}

// 5. Objects and Prototypes
function Event(name, date, seats, category, location) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
  this.location = location;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const yoga = new Event("Yoga", "2025-07-01", 5, "Health", "Community Center");
console.log(Object.entries(yoga));

// 6. Arrays and Methods
let communityEvents = [];

communityEvents.push(new Event("Baking Workshop", "2025-08-01", 20, "Culinary", "Kitchen Studio"));

const musicEvents = communityEvents.filter(e => e.name.includes("Music"));

const displayCards = communityEvents.map(e => `${e.name} - ${e.date}`);
console.log(displayCards);

// 7. DOM Manipulation
const container = document.querySelector("#events");

function renderEvents(eventsList) {
  container.innerHTML = "";
  eventsList.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>Date: ${event.date}</p>
      <p>Category: ${event.category}</p>
      <p>Location: ${event.location}</p>
      <p>Seats: ${event.seats}</p>
      <button class="registerBtn">Register</button>
    `;
    container.appendChild(card);
  });
  attachRegisterEvents();
}

// 8. Event Handling
function attachRegisterEvents() {
  document.querySelectorAll(".registerBtn").forEach((btn, index) => {
    btn.onclick = () => {
      tryRegister(events[index]);
      renderEvents(events);
    };
  });
}

document.querySelector("#categoryFilter").onchange = function () {
  const category = this.value;
  filterEventsByCategory(category, renderEvents);
};

document.querySelector("#searchInput").addEventListener("keydown", function (e) {
  if (e.key === "Enter") {
    const term = this.value;
    const results = events.filter(e => e.name.includes(term));
    renderEvents(results);
  }
});

// 9. Async JS, Promises, Async/Await
async function fetchEvents() {
  const loader = document.querySelector("#loader");
  loader.style.display = "block";

  try {
    const res = await fetch("events.json");
    const data = await res.json();
    events = data;
    renderEvents(events);
  } catch (err) {
    console.error("Error fetching:", err);
  } finally {
    loader.style.display = "none";
  }
}

// 10. Modern JavaScript Features
const greetUser = (name = "Guest") => `Welcome, ${name}`;

const event = { name: "Meetup", date: "2025-07-20", seats: 10 };
const { name, date } = event;

const updatedEvents = [...communityEvents];

// 11. Working with Forms
const form = document.querySelector("#registerForm");
form.onsubmit = function (e) {
  e.preventDefault();
  const { name, email, event: eventSelect } = form.elements;

  if (!name.value || !email.value) {
    document.querySelector("#error").textContent = "Please fill all fields";
    return;
  }

  console.log(`Registered: ${name.value}, ${email.value} for ${eventSelect.value}`);
};

// 12. AJAX & Fetch API
function submitRegistration(data) {
  fetch("https://mockapi.com/register", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  })
    .then(res => res.json())
    .then(res => {
      setTimeout(() => alert("Registration successful!"), 1000);
    })
    .catch(err => {
      alert("Error registering user");
    });
}

// 13. Debugging and Testing
// Use Chrome Dev Tools → Console & Network
// Use `debugger` in registration function
// Log every step:
console.log("Form submitted");
console.log("Fetching API...");

// 14. jQuery and JS Frameworks
// Assuming jQuery is loaded
$(document).ready(function () {
  $('#registerBtn').click(() => alert("Registered via jQuery!"));

  $('.event-card').fadeIn();
  $('.event-card').fadeOut();
});

// Benefit of frameworks like React/Vue:
// They offer component-based architecture, reactive UI updates, and state management, making large-scale apps easier to maintain.
