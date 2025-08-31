# The Project

## Deploy to Kubernetes

Deploy recursively all resources (namespace, pvc, todo-app, todo-backend)

```bash
kubectl apply -R -f manifests/
```

NOTICE 1: encrypted secrets (secret.enc.yaml) cannot be applied as is. You need to decrypt them first:

```bash
sops --decrypt secret.enc.yaml | kubectl apply -f -
```

NOTICE 2: If there is also "exercises" deployed, it's ingress may clash with the project. You can delete ingress defore deploying by:

```bash
kubectl delete ing log-output-ing -n exercises
```

## Use

Call API when running in k3d cluster:

```bash
    curl http://localhost:8081
```