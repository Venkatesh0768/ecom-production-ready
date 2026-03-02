import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  output: "standalone",
  serverExternalPackages: [
    "firebase-admin", // ~20MB, server-only SDK
    "nodemailer", // Email sending
    "pg", // PostgreSQL client
  ],
  experimental: {
    optimizePackageImports: [
      "lucide-react", // Icon library
      "date-fns", // Date utilities
      "lodash", // Utility functions
      "framer-motion", // Animations
      "recharts", // Charts
    ],
  },
};

export default nextConfig;
