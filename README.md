
# Web Crawler Email Extractor

This Java-based **Web Crawler Email Extractor** scans web pages to **find and extract email addresses**. It uses **JSoup** for web scraping and **regular expressions** to identify valid email patterns.

## Features
- **Web Crawling:** Traverses web pages recursively, following valid links.
- **Email Extraction:** Uses **regular expressions** to identify email addresses.
- **File Storage:** Saves extracted emails to a text file.
- **Duplicate Prevention:** Ensures emails are not collected multiple times.
- **Customizable Crawl Limit:** Limits the number of emails extracted (default: **700**).
- **Domain Restriction:** Crawls only links within a specified domain.

## How It Works
1. **Starts crawling from a given URL.**
2. **Extracts all visible text** and searches for emails using **regex**.
3. **Follows valid hyperlinks** to continue crawling within the specified domain.
4. **Writes found emails to `found_emails.txt`.**
5. **Stops when the maximum number of emails is reached.**

   
## Dependencies
- **JSoup Library (for web scraping)**
- **Java 8 or later**
- **Regex Matching (for extracting email addresses)**
  
##Applications
- **Data Mining: Extract contact emails for research.**
- **Web Scraping: Collect email addresses from specific domains.**
- **Cybersecurity: Identify publicly exposed emails.**
- **Marketing & Lead Generation: Find business contacts.**

