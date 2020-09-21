const co = require('co');
const PaintsBase = require('../base');
const mongo = require('../../../libs/mongo');

class ListPaints extends PaintsBase {
    handle() {
        const openId = this.openId;

        if (!openId) {
            return this.fail({ 'reason': 'openId does not exists' });
        }

        co.wrap(function *() {
            let db;

            try {
                db = yield mongo.connect();

                let paints = db.collection('paints');
                let doc = yield paints.find({ openId }, { _id: 0, openId: 0 }).toArray();

                this.success(doc);

            } catch (err) {
                this.fail({ 'reason': err.message });
            } finally {
                db && db.close();
            }

        }).call(this);
    }
}

module.exports = ListPaints.makeRouteHandler();