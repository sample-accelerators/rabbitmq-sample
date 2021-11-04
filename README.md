# Sample Rabbitmq App

This is a sample of a Java Spring app that works with the Tanzu Application Platform and Rabbitmq.

## Dependencies

1. [kubectl CLI](https://kubernetes.io/docs/tasks/tools/)
1. Tanzu CLI and the apps plugin v0.2.0 which are provided as part of [Tanzu Application Platform](https://network.tanzu.vmware.com/products/tanzu-application-platform)
1. A cluster with the [Rabbitmq cluster operator](https://github.com/rabbitmq/cluster-operator) installed.
1. A cluster with Tanzu Application Platform, and the "Default Supply Chain" and Services Toolkit components installed, plus their dependencies. These components are a part of [Tanzu Application Platform](https://network.tanzu.vmware.com/products/tanzu-application-platform).

## Usage after deployment

Once deployed, you can `curl` the top-level domain of the app and receive a response.

## Maintainers

Glen - @gmrodgers
Konstantin - @jhvhs
Sam - @Samze