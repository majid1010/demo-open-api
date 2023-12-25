# K8s Self-Hosted Runner 

Start Kubernetes locally or as EKS. Config files requires to run a runner locally is placed at k8s-configs directory.

## Installing using Helm

### 1- Install Cert manager 
```shell
helm repo add jetstack https://charts.jetstack.io
helm repo update
helm search repo cert-manager
helm install cert-manager jetstack/cert-manager --create-namespace --namespace=cert-manager \
     --version v1.13.3 --set prometheus.enabled=false --set installCRDs=true
```
And verify it in cert-manager namespace: `kubectl get pods -n cert-manager`  
      
### 2- Setup GitHub Authentication
We can use GitHub App and import private key as certificate into K8s secrets.
In creation of GutHub-App, grant "Actions"-> "Read-Only" and "Administration"->"Read and Write" permissions. Generate Key and install the app.

Create actions namespace where GitHub runners going to be executed there:
```shell
kubectl create namespace actions
```
This namespace is required for creation of secret:
```shell
kubectl create secret generic controller-manager -n actions \
--from-literal=github_app_id=714855 \
--from-literal=github_app_installation_id=45206683 \
--from-file=github_app_private_key=/Users/majid/Downloads/demo-github-actions.2023-12-17.private-key.pem 
```

`github_app_installation_id` can be taken from URL in browser 

### Deploy Actions Runners Controller (ARC) using Helm

```shell
helm repo add actions-runner-controller https://actions-runner-controller.github.io/actions-runner-controller

helm install action-runner actions-runner-controller/actions-runner-controller \
--namespace actions --create-namespace \
--version 0.23.7 --set syncPeriod=1m `
```

Need to wait couple of minutes and then verify the state through pod's logs:
```shell
kubectl logs -f example-single-runner -n actions runner
```
When the state is fine you can also verify this runner in Github majid1010/demo-open-api/settings/actions/runners
Now you can use it in a workflow (see .github/workflows/hosted-runner-single-runner-workflow.yaml)

## Open topics:
Verify shared values/resources
