module.exports = {
    'ArmorDemo' : function (browser) {
        browser
            .url('http:/localhost:8080')
            .waitForElementVisible('body', 1000)
            .click('button[name=landing-btn]')
            .end();
    }
};