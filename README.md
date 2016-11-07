# fyber-challenge
Web Testing Automation Challenge for Fyber

Usage: mvn clean install

Cucumber test reports are generated in target/cucumber-reports dir.

Only packages from public maven repositories are used.

Works "from scratch" only with CHROME web driver set in automation.conf.
For IE web driver appropriate env configuration should be applied.
FIREFOX is not yet supported due to known bugs in 3rd party web driver.