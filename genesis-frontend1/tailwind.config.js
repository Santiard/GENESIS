/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        "udes-blue": {
          50: "#f3f7fc",
          100: "#e7eff7",
          200: "#c9dcee",
          300: "#9abfdf",
          400: "#649dcc",
          500: "#4181b6",
          600: "#306699",
          700: "#28537e",
          800: "#244668",
          900: "#233c57",
          950: "#17273a",
        },
        "udes-gray": {
          50: "#f8f8f8",
          100: "#f2f2f2",
          200: "#dcdcdc",
          300: "#bdbdbd",
          400: "#989898",
          500: "#7c7c7c",
          600: "#656565",
          700: "#525252",
          800: "#464646",
          900: "#3d3d3d",
          950: "#292929",
        },
      },
    },
  },
  plugins: [],
};