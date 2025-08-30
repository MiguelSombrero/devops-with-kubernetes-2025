# Log output exercise

## Deploy to Kubernetes

Deploy recursively all resources (configmap, namespace, pvc, log-output-app, ping-pong-app)

```bash
kubectl apply -R -f manifests/
```

NOTICE 1: encrypted secrets (secret.enc.yaml) cannot be applied as is. You need to decrypt them first (run in same folder where the key.txt is):
```bash
sops --decrypt secret.enc.yaml | kubectl apply -f -
```

NOTICE 2: If there is also "the project" deployed, it's ingress may clash with this one. You can delete ingress defore deploying by:

```bash
kubectl delete ing todo-ing -n project
```

## Use

Call API when running in k3d cluster:

### To increment ping pongs:

```bash
    curl http://localhost:8081/pingpong
```

### To see count of ping pongs:

```bash
    curl http://localhost:8081/pings
```

### To fetch logs and ping pong:

```bash
    curl http://localhost:8081/
```
