package org.grails.plugins.smartclient

import grails.converters.JSON

class RemoteMethodExecutorController {
    def remoteMethodExecutor
    def configProvider


    def index() {
        def model
        if (request.JSON.transaction) {
            model = remoteMethodExecutor.executeTransaction(request.JSON.transaction)
        } else {
            model = remoteMethodExecutor.execute(request.JSON.data)
        }

        if (configProvider.converterConfig) {
            JSON.use(configProvider.converterConfig, {
                render(text: "${configProvider.jsonPrefix}${model as JSON}${configProvider.jsonSuffix}", contentType: 'application/json')
            })
        } else {
            render(text: "${configProvider.jsonPrefix}${model as JSON}${configProvider.jsonSuffix}", contentType: 'application/json')
        }
    }

    def init() {
        render(view: 'js', model: [jsonPrefix: configProvider.jsonPrefix, jsonSufix: configProvider.jsonSuffix], contentType: 'application/javascript')
    }


}